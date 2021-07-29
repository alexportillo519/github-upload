package com.alexp.coolcalc2

import org.junit.Test
import org.junit.Assert

class CoolCalcViewModelTest {

    private val viewModel = CoolCalcViewModel()

    @Test
    fun `when a user divides 515 by 8 should return 64 375`() {
        val actual = viewModel.calculate("/", 515.0, 8.0)
        assert(actual == 64.375)
    }

    @Test
    fun `when a user multiplies 88 by 6 it should return 528`() {
        val actual = viewModel.calculate("*", 88.0, 6.0)
        Assert.assertEquals(528.0, actual)
    }
}