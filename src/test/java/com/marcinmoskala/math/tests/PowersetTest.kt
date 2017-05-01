package com.marcinmoskala.math.tests

import com.marcinmoskala.math.pow
import com.marcinmoskala.math.powerset
import com.marcinmoskala.math.powersetSize
import junit.framework.Assert.assertEquals
import org.junit.Test

internal class PowersetTest {

    @Test fun `Sublists from empty list is only empty list`() {
        val emptyList = setOf<Int>()
        assertEquals(setOf(emptyList), emptyList.powerset())
    }

    @Test
    fun `Powerset simple example test`() {
        val set = setOf(
                setOf(1, 2, 3),
                setOf(1, 2),
                setOf(1, 3),
                setOf(2, 3),
                setOf(1),
                setOf(2),
                setOf(3),
                setOf())
        assertEquals(set, setOf(1, 2, 3).powerset())
    }

    @Test
    fun `Size of n element set powerset is 2^n`() {
        for(n in 1..6) {
            val set = (1..n).toSet()
            val size = 2.pow(n)
            assertEquals(size, set.powerset().size)
            assertEquals(size, set.powersetSize)
        }
    }
}