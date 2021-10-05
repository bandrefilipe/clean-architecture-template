package com.example

import kotlin.test.Test
import kotlin.test.assertEquals

internal class ExampleTest {

    private val testExample = Example()

    @Test
    fun `test Sum`() {
        val expected = 42
        assertEquals(expected, testExample.sum(40, 2))
    }
}
