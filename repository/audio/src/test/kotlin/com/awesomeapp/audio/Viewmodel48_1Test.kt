package com.awesomeapp.audio

import org.junit.Test
import org.junit.Before
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.junit.Rule
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.*
import kotlin.test.assertTrue
import kotlin.test.assertNotNull
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import com.awesomeapp.audio.*
import com.awesomeapp.audio.Repository48_5


@OptIn(ExperimentalCoroutinesApi::class)
class Viewmodel48_1Test {
        private lateinit var repository0: Repository48_5

    private lateinit var viewModel: Viewmodel48_1

    @Before
    fun setup() {
       repository0 = Repository48_5(com.awesomeapp.audio.Api48_6())
        viewModel = Viewmodel48_1(
            repository0
        )
    }

    @Test
    fun `test state updates with data`() = runTest {
        assertNotNull(viewModel.state.value)
    }
}
