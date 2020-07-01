package com.marcinmoskala.math.tests

import com.marcinmoskala.math.splitsNumber
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class NumberSplitTest {

    @Test fun `splitsNumber function for number is throwing error when asked for groupsNum of size smaller then 0`() {
        for (groupsNum in -10..-1) {
            for (num in 0..10) {
                assertIsThrowingError { num.splitsNumber(groupsNum) }
            }
        }
    }

    @Test
    fun `n number can be only one way splitted to one or n components`() {
        for (n in 1..100) {
            assertEquals(1, n.splitsNumber(1))
            assertEquals(1, n.splitsNumber(n))
        }
    }

    @Test
    fun `For 0 splits, number splits function is returning 1 for 0 and 0 otherwise`() {
        assertEquals(1, 0.splitsNumber(0))
        for (n in 1..100) {
            assertEquals(0, n.splitsNumber(0))
        }
    }

    @Test
    fun `Number splits function is correct according to recurrence definition`() {
        for (n in 1..10) {
            for (k in 1..(n - 1)) {
                assertEquals(n.splitsNumber(k), (1..k).sumBy { i -> (n - k).splitsNumber(i) })
            }
        }
    }

    @Test
    fun `Simple number splits examples are calculated correctly`() {
        assertEquals(3, 7.splitsNumber(4))
        assertEquals(11, 11.splitsNumber(4))
        assertEquals(5, 9.splitsNumber(5))
        assertEquals(7, 13.splitsNumber(8))
    }
}