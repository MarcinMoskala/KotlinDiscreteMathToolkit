package com.marcinmoskala.math.tests

import com.marcinmoskala.math.combinationsWithRepetitions
import com.marcinmoskala.math.combinationsWithRepetitionsNumber
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CombinationWithRepetitionTest {

    @Test fun `combinationsWithRepetitions function is throwing error when asked for subsets of size smaller then 0`() {
        val set = setOf(1, 2, 3, 4)
        for (subsetSize in -10..-1) {
            assertIsThrowingError { set.combinationsWithRepetitions(subsetSize) }
        }
    }

    @Test fun `combinationsWithRepetitionsNumber function is throwing error when asked for subsets of size smaller then 0`() {
        val set = setOf(1, 2, 3, 4)
        for (subsetSize in -10..-1) {
            assertIsThrowingError { set.combinationsWithRepetitionsNumber(subsetSize) }
        }
    }

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

    @Test fun `Simple combinationsWithRepetitions test`() {
        val set = setOf(1, 2, 3)
        val sizeToCombinations = mapOf<Int, Set<Map<Int, Int>>>(
                0 to setOf(mapOf<Int, Int>()),
                1 to setOf(mapOf(1 to 1), mapOf(2 to 1), mapOf(3 to 1)),
                2 to setOf(mapOf(1 to 1, 2 to 1), mapOf(2 to 1, 3 to 1), mapOf(1 to 1, 3 to 1), mapOf(1 to 2), mapOf(2 to 2), mapOf(3 to 2))
        )
        for ((subsetSize, expectedCombinations) in sizeToCombinations) {
            assertEquals(expectedCombinations, set.combinationsWithRepetitions(subsetSize))
        }
    }
}