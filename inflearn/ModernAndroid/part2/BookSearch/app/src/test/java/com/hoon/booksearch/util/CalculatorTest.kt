package com.hoon.booksearch.util

import com.google.common.truth.Truth.assertThat
import androidx.test.filters.SmallTest
import org.junit.After
import org.junit.Before
import org.junit.Test

@SmallTest
class CalculatorTest {
//    private val calculator = Calculator()

    private lateinit var calculator: Calculator

    @Before
    fun setUp() {
//        각 테스트의 실행 직전에 수행되어야 하는 작업
        calculator = Calculator()
    }

    @After
    fun tearDown() {
//        각 테스트 직후에 수행되어야 하는 작업
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