package com.marcinmoskala.math.tests

import com.marcinmoskala.math.permutationNumber
import com.marcinmoskala.math.permutations
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class PermutationTest {

    @Test fun `Test permutation numbers for Sets with different sizes`() {
        val setSizeToPermutations = mapOf(
                0 to 0L,
                1 to 1L,
                2 to 2L,
                3 to 6L,
                4 to 24L
        )
        for ((setSize, expectedNumber) in setSizeToPermutations) {
            val set = (1..setSize).toSet()
            assertEquals(expectedNumber, set.permutationNumber())
        }
    }

    @Test fun `Test permutation numbers for Lists with different sizes and different elements`() {
        val listSizeToPermutations = mapOf(
                0 to 0L,
                1 to 1L,
                2 to 2L,
                3 to 6L,
                4 to 24L
        )
        for ((listSize, expectedNumber) in listSizeToPermutations) {
            val set = (1..listSize).toList()
            assertEquals(expectedNumber, set.permutationNumber())
        }
    }

    @Test fun `Test permutation numbers for Lists with different sizes and same elements`() {
        val listToPermutations = mapOf(
                listOf(1, 1, 1, 1) to 1L,
                listOf(1, 1, 2, 2) to 6L,
                listOf(1, 1, 1, 2) to 4L
        )
        for ((list, expectedNumber) in listToPermutations) {
            assertEquals(expectedNumber, list.permutationNumber())
        }
    }

    @Test fun `Get all permutations for different elements`() {
        val setToPermutations = mapOf(
                setOf<Int>() to setOf<List<Int>>(),
                setOf(1, 2) to setOf(listOf(1, 2), listOf(2, 1)),
                setOf(1, 2, 3) to setOf(listOf(1, 2, 3), listOf(2, 1, 3), listOf(1, 3, 2), listOf(2, 3, 1), listOf(3, 1, 2), listOf(3, 2, 1))
        )
        for ((set, allExpectedPermutations) in setToPermutations) {
            assertEquals(allExpectedPermutations, set.permutations())
        }
    }

    @Test fun `Check permutations number in allPermutations for bigger numbers`() {
        val set = (1..5).toSet()
        assertEquals(set.permutationNumber(), set.permutations().size.toLong())
    }
}