package com.marcinmoskala.math.tests

import com.marcinmoskala.math.S
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SplitFuncTest {

    @Test
    fun `n elements can be only one way splitted to one or n groups`() {
        for(n in 1..100) {
            assertEquals(1, S(n, 1))
            assertEquals(1, S(n, n))
        }
    }
}