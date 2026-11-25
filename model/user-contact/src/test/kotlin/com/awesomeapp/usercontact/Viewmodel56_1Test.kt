package com.awesomeapp.usercontact

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
import com.awesomeapp.usercontact.*
import com.awesomeapp.usercontact.Repository56_5


@OptIn(ExperimentalCoroutinesApi::class)
class Viewmodel56_1Test {
        private lateinit var repository0: Repository56_5

    private lateinit var viewModel: Viewmodel56_1

    @Before
    fun setup() {
       repository0 = Repository56_5(com.awesomeapp.usercontact.Api56_6())
        viewModel = Viewmodel56_1(
            repository0
        )
    }

    @Test
    fun `test state updates with data`() = runTest {
        assertNotNull(viewModel.state.value)
    }
}
