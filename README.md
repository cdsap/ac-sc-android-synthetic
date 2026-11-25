# ac-sc-android-synthetic

A synthetic Android project, generated with [ProjectGenerator](https://github.com/cdsap/ProjectGenerator) v0.7.1. It is
used to exercise the Develocity Artifact Cache and Setup Cache from GitHub Actions with
[`gradle/develocity-artifact-cache-github-action`](https://github.com/gradle/develocity-artifact-cache-github-action).

```
projectGenerator generate-project --type android --language kts --shape rectangle --modules 60 --layers 5 \
  --di hilt --classes-module 20 --generate-unit-test --develocity --project-name ac-sc-android-synthetic
```

60 modules in 5 layers, Hilt, unit tests, AGP 9.5.2, Kotlin 2.4.21, Gradle 9.9.2. Build Scans are published only when
`DEVELOCITY_URL` is set (see `settings.gradle.kts`).

## Setup

Repository secrets:

| secret | value |
|---|---|
| `DEVELOCITY_URL` | Develocity server URL, e.g. `https://develocity.example.com` |
| `DEVELOCITY_ACCESS_KEY` | access key in `host=key` form, e.g. `develocity.example.com=<key>` (the host must match `DEVELOCITY_URL`). It needs the **Read and write Build Cache data** permission, or the Edge rejects every store with `Unauthorized access to remote cache`. |
| `DEVELOCITY_EDGE_HOST` | optional: the Edge hostname, only so it is masked in the public logs |

Each job first masks the Develocity host (taken from `DEVELOCITY_URL`) and the Edge host, because the CLI prints both
and GitHub only masks exact secret values.

Until `DEVELOCITY_URL` is set, `build.yml` skips the AC/SC step and builds without caching. `ac-sc-restore-tuning.yml`
requires both. Pull requests from forks get no secrets, so they also build without caching.

Optional repository variable `AC_CLI_ENV`: extra environment for the Artifact Cache CLI, one `NAME=value` per line.
Both workflows write it to `GITHUB_ENV` before the AC/SC action, so the restore (main step) and the store (post step)
both see it.

## Workflows

| workflow | trigger | what it does |
|---|---|---|
| `build.yml` | push, PR, manual | `assembleDebug testDebugUnitTest`, with the AC/SC action restoring before the build and storing in its post step. Uploads the CLI logs and JFRs (`--reporting-directory`). |
| `ac-sc-restore-tuning.yml` | manual | A seed job stores a fixed cache image from a full build. A 2×2 matrix of fresh runners then restores it read-only with `--operation-concurrency` 4/16 × `--operation-timeout` PT60S/PT5M, and builds `--offline`. Input: `command-timeout` (CLI `--timeout`, default PT2M). |

The CLI runs with `--autodetect=GRADLE`, so it caches the Gradle User Home only, not the runner's Docker images, npm or pip
caches.

Both workflows apply `setup-gradle` before the AC/SC action, with `cache-provider: external`, so the CLI uses the same
Gradle User Home and `setup-gradle` does not cache it a second time. `setup-gradle` also gets the access key, for
Build Scans: the AC/SC action exchanges its key for a short-lived token and does not export it to other steps.

### Restore tuning: what to read

- **Job summary of each restore job:** the action's per-phase cache metrics (entries, bytes, duration).
- **Build Scan of the offline build:** how many artifact transforms still executed after the restore.
- **`ac-logs-*` artifacts:** CLI logs at `--verbose`, plus JFR recordings to look at where slow restores spend their
  time.
- **Per-entry timeout:** a single entry that takes longer than `--operation-timeout` (default 60 s) is cancelled by the
  CLI itself. A proxy in front of the Edge logs that as a stream reset at that time.

The action manages `--dv-server`, `--image-name` and `--cache-metrics-file`, and rejects them in
`additional-cli-args`. Use `image-names` to pin a cache key.
