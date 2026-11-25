package com.awesomeapp.forecast

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
import com.awesomeapp.forecast.*
import com.awesomeapp.forecast.Repository40_5


@OptIn(ExperimentalCoroutinesApi::class)
class Viewmodel40_1Test {
        private lateinit var repository0: Repository40_5

    private lateinit var viewModel: Viewmodel40_1

    @Before
    fun setup() {
       repository0 = Repository40_5(com.awesomeapp.forecast.Api40_6())
        viewModel = Viewmodel40_1(
            repository0
        )
    }

    @Test
    fun `test state updates with data`() = runTest {
        assertNotNull(viewModel.state.value)
    }
}
