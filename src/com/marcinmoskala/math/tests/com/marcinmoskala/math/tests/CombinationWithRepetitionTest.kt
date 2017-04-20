package com.marcinmoskala.math.tests

import com.marcinmoskala.math.combinationsWithRepetitionsNumber
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CombinationWithRepetitionTest {

    @Test fun `Test combinationsWithRepetitionsNumber for Sets with different sizes`() {
        val set = setOf(1, 2, 3)
        val subsetSizeToCombinationNumber = mapOf(
                0 to 1L,
                1 to 3L,
                2 to 6L,
                3 to 10L,
                4 to 15L,
                5 to 21L
        )
        for ((subsetSize, expectedCombinationNumber) in subsetSizeToCombinationNumber) {
            assertEquals(expectedCombinationNumber, set.combinationsWithRepetitionsNumber(subsetSize))
        }
    }
}