package com.marcinmoskala.math.tests

import com.marcinmoskala.math.sublistsBySplitters
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SublistsBySplittersTest {

    @Test fun `Sublists from empty list is only empty list`() {
        val emptyList = listOf<Int>()
        assertEquals(listOf(emptyList), emptyList.sublistsBySplitters { true })
        assertEquals(listOf(emptyList), emptyList.sublistsBySplitters { false })
    }

    @Test
    fun `Sublists order is from biggest list to empty with elements in natural order`() {
        assertEquals(listOf(listOf(1, 2), listOf(1), listOf(2), listOf()), listOf(1, 2).sublistsBySplitters { true })
        assertEquals(listOf(listOf(1, 2), listOf(1)), listOf(1, 2).sublistsBySplitters { it % 2 == 0 })
    }

    @Test
    fun `Sublist creation for mixed splitters and simple`() {
        assertEquals(setOf(listOf(1, 2, 3), listOf(1, 3)), listOf(1, 2, 3).sublistsBySplitters { it % 2 == 0 }.toSet())
        assertEquals(setOf(listOf(1, 2, 3, 4), listOf(1, 2, 3), listOf(1, 3, 4), listOf(1, 3)), listOf(1, 2, 3, 4).sublistsBySplitters { it % 2 == 0 }.toSet())
    }

    @Test
    fun `Big sublists results sizes are correct`() {
        // 10 splitters, so 2^10 = 1024 lists
        assert((1..20).toList().sublistsBySplitters { it % 2 == 0 }.size == 1024)
        assert((1..40).toList().sublistsBySplitters { it % 4 == 0 }.size == 1024)
    }
}