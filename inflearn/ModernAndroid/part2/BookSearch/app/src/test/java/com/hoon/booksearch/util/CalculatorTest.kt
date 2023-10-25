package com.hoon.booksearch.util

import androidx.test.filters.SmallTest
import org.junit.Test
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before

@SmallTest
class CalculatorTest {

//    private val calculator = Calculator()

    private lateinit var calculator: Calculator

    @Before
    fun setUp() {
        calculator = Calculator()
    }

    @After
    fun tearDown() {

    }

    @Test
    fun `additional function test`() {
        // Given
        val x = 4
        val y = 2

        // When
        val result = calculator.addition(x, y)

        // Then
        assertThat(result).isEqualTo(6)
    }

    @Test
    fun `subtraction function test`() {
        // Given
        val x = 4
        val y = 2

        // When
        val result = calculator.subtraction(x, y)

        // Then
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun `multiplication function test`() {
        // Given
        val x = 4
        val y = 2

        // When
        val result = calculator.multiplication(x, y)

        // Then
        assertThat(result).isEqualTo(8)
    }

    @Test
    fun `division function test`() {
        // Given
        val x = 4
        val y = 0

        // When
        val result = calculator.division(x, y)

        // Then
        assertThat(result).isEqualTo(null)
    }

}