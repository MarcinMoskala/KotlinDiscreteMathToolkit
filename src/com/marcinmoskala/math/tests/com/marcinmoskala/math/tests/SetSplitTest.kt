package com.marcinmoskala.math.tests

import com.marcinmoskala.math.S
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SetSplitTest {

    @Test
    fun `n elements can be only one way splitted to one or n groups`() {
        for (n in 1..100) {
            assertEquals(1, S(n, 1))
            assertEquals(1, S(n, n))
        }
    }

    @Test
    fun `For 0 splits, Stirling function is returning 1 for 0 and 0 otherwise`() {
        assertEquals(1, S(0, 0))
        for (n in 1..100) {
            assertEquals(0, S(n, 0))
        }
    }

    @Test
    fun `Stirling function is correct according to recrrence defenition`() {
        for (n in 1..10) {
            for (k in 1..(n - 1)) {
                assertEquals(S(n, k), S(n - 1, k - 1) + k * S(n - 1, k))
            }
        }
    }

    @Test
    fun `Simple set splits examples are calculated correctly`() {
        assertEquals(1, S(3, 1))
        assertEquals(3, S(3, 2))
        assertEquals(7, S(4, 2))
        assertEquals(25, S(5, 3))
        assertEquals(140, S(7, 5))
        assertEquals(350, S(7, 4))
    }
}