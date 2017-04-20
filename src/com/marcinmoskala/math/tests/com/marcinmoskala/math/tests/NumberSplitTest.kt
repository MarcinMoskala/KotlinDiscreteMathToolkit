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

}