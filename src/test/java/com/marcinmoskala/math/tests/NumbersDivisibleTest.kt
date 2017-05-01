package com.marcinmoskala.math.tests

import com.marcinmoskala.math.countDivisiveBy
import com.marcinmoskala.math.countNonDivisiveBy
import com.marcinmoskala.math.divisiveBy
import com.marcinmoskala.math.nonDivisiveBy
import junit.framework.Assert.assertEquals
import org.junit.Test

internal class NumbersDivisibleTest {

    @Test fun `Simple count divisible test`() {
        assertEquals(462, (1..1000).countNonDivisiveBy(2, 6, 13))
        assertEquals(520, (1..1000).countNonDivisiveBy(3, 7, 11))
        assertEquals(768, (1..1000).countNonDivisiveBy(6, 9, 33))
    }

    @Test fun `Simple count nondivisible test`() {
        assertEquals(1000 - 462, (1..1000).countDivisiveBy(2, 6, 13))
        assertEquals(1000 - 520, (1..1000).countDivisiveBy(3, 7, 11))
        assertEquals(1000 - 768, (1..1000).countDivisiveBy(6, 9, 33))
    }

    @Test fun `Simple divisible test`() {
        assertEquals(listOf(1, 5, 7), (1..10).nonDivisiveBy(2, 3))
    }

    @Test fun `Simple nondivisible test`() {
        assertEquals(listOf(2, 3, 4, 6, 8, 9, 10), (1..10).divisiveBy(2, 3))
    }

    @Test fun `Divisible (and non divisible) size and count matches`() {
        val r = (1..100)
        for(i in 1..10) {
            for(j in 1..10) {
                assertEquals(r.countDivisiveBy(i, j), r.divisiveBy(i, j).size)
                assertEquals(r.countNonDivisiveBy(i, j), r.nonDivisiveBy(i, j).size)
            }
        }
    }
}