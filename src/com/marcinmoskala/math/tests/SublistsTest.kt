package com.marcinmoskala.math.tests

import com.marcinmoskala.math.sublists
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SublistsTest {

    @Test fun `Sublists from empty list is only empty list`() {
        val emptyList = listOf<Int>()
        assertEquals(listOf(emptyList), emptyList.sublists())
        assertEquals(listOf(emptyList), emptyList.sublists { false })
    }

    @Test
    fun `Sublists order is from biggest list to empty with elements in natural order`() {
        assertEquals(listOf(listOf(1, 2), listOf(1), listOf(2), listOf()), listOf(1, 2).sublists())
        assertEquals(listOf(listOf(1, 2), listOf(1)), listOf(1, 2).sublists { it % 2 == 0 })
    }

    @Test
    fun `Sublist creation for mixed splitters and simple`() {
        assertEquals(setOf(listOf(1, 2, 3), listOf(1, 3)), listOf(1, 2, 3).sublists { it % 2 == 0 }.toSet())
        assertEquals(setOf(listOf(1, 2, 3, 4), listOf(1, 2, 3), listOf(1, 3, 4), listOf(1, 3)), listOf(1, 2, 3, 4).sublists { it % 2 == 0 }.toSet())
    }


}