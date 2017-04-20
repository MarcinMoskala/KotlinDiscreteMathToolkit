package com.marcinmoskala.math.tests

import com.marcinmoskala.math.P
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class NumberSplitTest {

    @Test
    fun `n number can be only one way splitted to one or n components`() {
        for (n in 1..100) {
            assertEquals(1, P(n, 1))
            assertEquals(1, P(n, n))
        }
    }

    @Test
    fun `For 0 splits, number splits function is returning 1 for 0 and 0 otherwise`() {
        assertEquals(1, P(0, 0))
        for (n in 1..100) {
            assertEquals(0, P(n, 0))
        }
    }

    @Test
    fun `Number splits function is correct according to recurrence definition`() {
        for (n in 1..10) {
            for (k in 1..(n - 1)) {
                assertEquals(P(n, k), (1..k).sumBy { i -> P(n - k, i) })
            }
        }
    }

    @Test
    fun `Simple number splits examples are calculated correctly`() {
        assertEquals(3, P(7, 4))
        assertEquals(11, P(11, 4))
        assertEquals(5, P(9, 5))
        assertEquals(7, P(13, 8))
    }
}