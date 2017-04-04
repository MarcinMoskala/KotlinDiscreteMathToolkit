package com.marcinmoskala.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class PermutationTest {

    @Test fun `Test small number permutation numbers`() {
        val setSizeToPermutations = mapOf(
                0 to 0,
                1 to 1,
                2 to 2,
                3 to 6,
                4 to 24
        )
        for ((setSize, expectedNumber) in setSizeToPermutations) {
            val set = (1..setSize).toSet()
            assertEquals(expectedNumber, set.permutationNumber())
        }
    }
}