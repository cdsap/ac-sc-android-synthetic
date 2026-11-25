package com.awesomeapp.cartcontact

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
import com.awesomeapp.cartcontact.*


@OptIn(ExperimentalCoroutinesApi::class)
class Viewmodel55_1Test {
        private lateinit var viewModel: Viewmodel55_1

    @Before
    fun setup() {
        viewModel = Viewmodel55_1()
    }

    @Test
    fun `test state updates with data`() = runTest {
        assertNotNull(viewModel.state.value)
    }
}
