package com.marcinmoskala.math.tests

import com.marcinmoskala.math.combinationNumber
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class CombinationTest {

    @Test fun `Test combination numbers for Sets with different sizes`() {
        val set = setOf(1, 2, 3, 4)
        val subsetSizeToCombinationNumber = mapOf(
                0 to 0L,
                1 to 4L,
                2 to 6L,
                3 to 4L,
                4 to 1L,
                5 to 1L
        )
        for ((subsetSize, expectedCombinationNumber) in subsetSizeToCombinationNumber) {
            Assertions.assertEquals(expectedCombinationNumber, set.combinationNumber(subsetSize))
        }
    }
}