pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    id("com.gradle.develocity") version "4.6.1"
    id("com.gradle.common-custom-user-data-gradle-plugin") version "2.2"
    id("com.fueledbycaffeine.spotlight") version "1.8.0"
}
rootProject.name = "ac-sc-android-synthetic"
develocity {
    // Set DEVELOCITY_URL in CI (repository variable); without it no Build Scan is published.
    val develocityUrl = providers.environmentVariable("DEVELOCITY_URL").orNull?.takeIf { it.isNotBlank() }
    if (develocityUrl != null) {
        server = develocityUrl
    }
    buildScan {
        publishing.onlyIf { develocityUrl != null }
        uploadInBackground.set(false)
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
include (":core:push")
include (":core:contact")
include (":core:login")
include (":core:identity")
include (":core:checkout")
include (":core:cart")
include (":core:user")
include (":core:profile")
include (":core:feed")
include (":core:comment")
include (":core:post")
include (":core:search")
include (":feature:location")
include (":feature:network")
include (":feature:sync")
include (":feature:share")
include (":feature:group")
include (":feature:message")
include (":feature:notification")
include (":feature:setting")
include (":feature:account")
include (":feature:session")
include (":feature:analytics")
include (":feature:report")
include (":domain:log")
include (":domain:status")
include (":domain:metric")
include (":domain:task")
include (":domain:calendar")
include (":domain:event")
include (":domain:alarm")
include (":domain:timer")
include (":domain:file")
include (":domain:document")
include (":domain:note")
include (":domain:todo")
include (":repository:list")
include (":repository:map")
include (":repository:weather")
include (":repository:forecast")
include (":repository:news")
include (":repository:article")
include (":repository:podcast")
include (":repository:video")
include (":repository:photo")
include (":repository:gallery")
include (":repository:media")
include (":repository:audio")
include (":model:playlist")
include (":model:push-contact")
include (":model:contact-contact")
include (":model:login-contact")
include (":model:identity-contact")
include (":model:checkout-contact")
include (":model:cart-contact")
include (":model:user-contact")
include (":model:profile-contact")
include (":model:feed-contact")
include (":model:comment-contact")
include (":model:post-contact")
include (":app:app")
