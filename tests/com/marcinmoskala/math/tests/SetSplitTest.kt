package com.marcinmoskala.math.tests

import com.marcinmoskala.math.splits
import com.marcinmoskala.math.splitsNumber
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SetSplitTest {

    fun set(size: Int) = (1..size).toSet()

    @Test
    fun `n elements can be only one way splitted to one or n groups`() {
        for (n in 1..100) {
            assertEquals(1, set(n).splitsNumber(1))
            assertEquals(1, set(n).splitsNumber(n))
        }
    }

    @Test
    fun `For 0 splits, Stirling function is returning 1 for 0 and 0 otherwise`() {
        assertEquals(1, set(0).splitsNumber(0))
        for (n in 1..100) {
            assertEquals(0, set(n).splitsNumber(0))
        }
    }

    @Test
    fun `Stirling function is correct according to recurrence definition`() {
        for (n in 1..10) {
            for (k in 1..(n - 1)) {
                assertEquals(
                        set(n).splitsNumber(k),
                        set(n - 1).splitsNumber(k - 1) + k * set(n - 1).splitsNumber(k)
                )
            }
        }
    }

    @Test
    fun `Simple set splits number for examples are calculated correctly`() {
        assertEquals(1, set(3).splitsNumber(1))
        assertEquals(3, set(3).splitsNumber(2))
        assertEquals(7, set(4).splitsNumber(2))
        assertEquals(25, set(5).splitsNumber(3))
        assertEquals(140, set(7).splitsNumber(5))
        assertEquals(350, set(7).splitsNumber(4))
    }

    @Test
    fun `There is no splits to 0, except empty set`() {
        assertEquals(setOf(emptySet<Int>()), set(0).splits(0))
        for (n in 1..100) assertEquals(emptySet<Set<Int>>(), set(n).splits(0))
    }

    @Test
    fun `Split to 1 is returning only base set`() {
        (1..10).map { set(it) }.forEach { s -> assertEquals(setOf(setOf(s)), s.splits(1)) }
    }

    @Test
    fun `Split to set size is returning set with each element separated`() {
        (1..10).map { set(it) }.forEach { s -> assertEquals(setOf(s.map { setOf(it) }.toSet()), s.splits(s.size)) }
    }

    @Test
    fun `Simple set split is correct`() {
        assertEquals(setOf(setOf(setOf(1, 2), setOf(3)), setOf(setOf(1, 3), setOf(2)), setOf(setOf(3, 2), setOf(1))), setOf(1, 2, 3).splits(2))
    }

    @Test
    fun `Splits size and splitsNumber matches`() {
        for(i in 1..5) for(j in 1..5) {
            val s = set(i)
            assertEquals(s.splitsNumber(j), s.splits(j).size)
        }
    }
}