package com.marcinmoskala.math.tests

import com.marcinmoskala.math.combinationNumber
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CombinationTest {

    @Test fun `Test combination numbers for Sets with different sizes`() {
        val set = setOf(1, 2, 3, 4)
        assertEquals(0, set.combinationNumber(0))
        assertEquals(4, set.combinationNumber(1))
        assertEquals(6, set.combinationNumber(2))
        assertEquals(4, set.combinationNumber(3))
        assertEquals(1, set.combinationNumber(4))
        assertEquals(1, set.combinationNumber(5))
    }
}