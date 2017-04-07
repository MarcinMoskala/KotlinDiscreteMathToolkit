package com.marcinmoskala.math.tests

import com.marcinmoskala.math.sublists
import com.marcinmoskala.math.powerSet
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SubsetsTest {

    @Test fun `Sublists from empty list is only empty list`() {
        val emptyList = setOf<Int>()
        assertEquals(setOf(emptyList), emptyList.powerSet())
    }

    @Test
    fun `Sublist simple list test`() {
        val set = setOf(
                setOf(1, 2, 3),
                setOf(1, 2),
                setOf(1, 3),
                setOf(2, 3),
                setOf(1),
                setOf(2),
                setOf(3),
                setOf())
        assertEquals(set, setOf(1, 2, 3).powerSet().toSet())
    }

    @Test
    fun `Simple list combine test`() {
        val set = setOf(
                setOf(1, 2, 3),
                setOf(1, 2),
                setOf(1, 3),
                setOf(2, 3),
                setOf(1),
                setOf(2),
                setOf(3),
                setOf())
        assertEquals(set, setOf(1, 2, 3).powerSet())
    }

    @Test
    fun `Compare Combine and subsets`() {
        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8)
        assertEquals(list.toSet().powerSet(), list.sublists().map { it.toSet() }.toSet())
    }
}