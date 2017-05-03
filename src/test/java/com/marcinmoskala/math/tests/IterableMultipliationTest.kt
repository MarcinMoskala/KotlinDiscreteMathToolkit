package com.marcinmoskala.math.tests

import com.marcinmoskala.math.times
import junit.framework.Assert.assertEquals
import org.junit.Test

internal class IterableMultipliationTest {

    @Test fun `When one list empty then multiplication is also returning empty`() {
        assertEquals(listOf<Int>(), listOf<Int>() * listOf<Int>())
        assertEquals(listOf<Int>(), listOf<Int>(1) * listOf<Int>())
        assertEquals(listOf<Int>(), listOf<Int>() * listOf<Int>(1))
        assertEquals(listOf<Int>(), listOf<Int>(1, 2) * listOf<Int>())
    }
}