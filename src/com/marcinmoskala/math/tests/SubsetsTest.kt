package com.marcinmoskala.math.tests

import com.marcinmoskala.math.subsets
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SubsetsTest {

    @Test fun `Sublists from empty list is only empty list`() {
        val emptyList = setOf<Int>()
        assertEquals(setOf(emptyList), emptyList.subsets())
    }

    @Test
    fun `Sublist creation for mixed splitters and simple`() {
        val set = setOf(
                setOf(1, 2, 3),
                setOf(1, 2),
                setOf(1, 3),
                setOf(2, 3),
                setOf(1),
                setOf(2),
                setOf(3),
                setOf()
        )
        assertEquals(set, setOf(1, 2, 3).subsets().toSet())
    }
}