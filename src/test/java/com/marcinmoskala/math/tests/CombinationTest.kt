package com.marcinmoskala.math.tests

import com.marcinmoskala.math.combinations
import com.marcinmoskala.math.combinationsNumber
import junit.framework.Assert.assertEquals
import org.junit.Test

internal class CombinationTest {

    @Test fun `combinations function is throwing error when asked for subsets of size smaller then 0`() {
        val set = setOf(1, 2, 3, 4)
        for (subsetSize in -10..-1) {
            assertIsThrowingError { set.combinations(subsetSize) }
        }
    }

    @Test fun `combinationsNumber function is throwing error when asked for subsets of size smaller then 0`() {
        val set = setOf(1, 2, 3, 4)
        for (subsetSize in -10..-1) {
            assertIsThrowingError { set.combinationsNumber(subsetSize) }
        }
    }

    @Test fun `Test combinationsNumber for Sets with different sizes`() {
        val set = setOf(1, 2, 3, 4)
        val subsetSizeToCombinationNumber = mapOf(
                0 to 1L,
                1 to 4L,
                2 to 6L,
                3 to 4L,
                4 to 1L,
                5 to 1L
        )
        for ((subsetSize, expectedCombinationNumber) in subsetSizeToCombinationNumber) {
            assertEquals(expectedCombinationNumber, set.combinationsNumber(subsetSize))
        }
    }

    @Test fun `Test combinations for Sets with different sizes`() {
        val set = setOf(1, 2, 3, 4)
        val sizeToCombinations = mapOf(
                0 to setOf(setOf()),
                1 to setOf(setOf(1), setOf(2), setOf(3), setOf(4)),
                2 to setOf(setOf(1, 2), setOf(2, 3), setOf(3, 4), setOf(1, 3), setOf(2, 4), setOf(1, 4)),
                3 to setOf(setOf(1, 2, 3), setOf(1, 2, 4), setOf(1, 3, 4), setOf(2, 3, 4)),
                4 to setOf(setOf(1, 2, 3, 4)),
                5 to setOf(setOf(1, 2, 3, 4))
        )
        for ((subsetSize, expectedCombinations) in sizeToCombinations) {
            assertEquals(expectedCombinations, set.combinations(subsetSize))
        }
    }

    @Test fun `Test combinations size and combinationsNumber correctness`() {
        val set = (1..6).toSet()
        (1..7).forEach { i -> assertEquals(set.combinationsNumber(i), set.combinations(i).size.toLong()) }
    }
}