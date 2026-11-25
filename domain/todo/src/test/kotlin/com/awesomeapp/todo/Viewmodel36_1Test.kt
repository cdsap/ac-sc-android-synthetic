package com.awesomeapp.todo

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
import com.awesomeapp.todo.*
import com.awesomeapp.todo.Repository36_5


@OptIn(ExperimentalCoroutinesApi::class)
class Viewmodel36_1Test {
        private lateinit var repository0: Repository36_5

    private lateinit var viewModel: Viewmodel36_1

    @Before
    fun setup() {
       repository0 = Repository36_5(com.awesomeapp.todo.Api36_6())
        viewModel = Viewmodel36_1(
            repository0
        )
    }

    @Test
    fun `test state updates with data`() = runTest {
        assertNotNull(viewModel.state.value)
    }
}
