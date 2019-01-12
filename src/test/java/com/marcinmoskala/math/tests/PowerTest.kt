package com.marcinmoskala.math.tests

import com.marcinmoskala.math.pow
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Test

@Suppress("USELESS_IS_CHECK")
internal class PowerTest {

    @Test
    fun `Power for Number tests`() {
        assertEquals(4.0, (2 as Number).pow(2))
        assertEquals(81.0, (3 as Number).pow(4))
        assertEquals(100000.0, (10 as Number).pow(5))
        assertTrue((10 as Number).pow(5) is Double)
    }

    @Test
    fun `Power for Int tests`() {
        assertEquals(4, 2.pow(2))
        assertEquals(81, 3.pow(4))
        assertEquals(100000, 10.pow(5))
        assertTrue(10.pow(5) is Int)
    }

    @Test
    fun `Power for Double tests`() {
        assertEquals(4.0, 2.0.pow(2))
        assertEquals(81.0, 3.0.pow(4))
        assertEquals(100000.0, 10.0.pow(5))
        assertTrue(2.0.pow(5) is Double)
    }
}