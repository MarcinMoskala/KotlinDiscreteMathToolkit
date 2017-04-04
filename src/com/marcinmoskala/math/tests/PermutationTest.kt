package com.marcinmoskala.math.tests

import com.marcinmoskala.math.permutationNumber
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
        val setSizeToPermutations = mapOf(
                0 to 0L,
                1 to 1L,
                2 to 2L,
                3 to 6L,
                4 to 24L
        )
        for ((setSize, expectedNumber) in setSizeToPermutations) {
            val set = (1..setSize).toList()
            assertEquals(expectedNumber, set.permutationNumber())
        }
    }
}