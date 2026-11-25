package com.awesomeapp.timer

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
import com.awesomeapp.timer.*
import com.awesomeapp.timer.Repository32_5


@OptIn(ExperimentalCoroutinesApi::class)
class Viewmodel32_1Test {
        private lateinit var repository0: Repository32_5

    private lateinit var viewModel: Viewmodel32_1

    @Before
    fun setup() {
       repository0 = Repository32_5(com.awesomeapp.timer.Api32_6())
        viewModel = Viewmodel32_1(
            repository0
        )
    }

    @Test
    fun `test state updates with data`() = runTest {
        assertNotNull(viewModel.state.value)
    }
}
