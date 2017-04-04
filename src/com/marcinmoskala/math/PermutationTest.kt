package com.marcinmoskala.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class PermutationTest {

    @Test fun `There is 0 permutations of empty set`() {
        assertEquals(0, setOf<Int>().permutationNumber)
    }

    @Test fun `There is 1 permutation of single element set`() {
        assertEquals(1, setOf(1).permutationNumber)
    }
}