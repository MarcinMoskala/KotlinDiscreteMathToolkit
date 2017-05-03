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

    @Test fun `When size of one list is 1 then multiplication of it with other list returns list with size of second with element of it paired with element from other list`() {
        assertEquals(listOf("A" to 1, "A" to 2), listOf("A") * listOf(1, 2))
        assertEquals(listOf("A" to 1, "A" to 2, "A" to 3), listOf("A") * listOf(1, 2, 3))
        assertEquals(listOf("A" to 1, "A" to 2, "A" to 2), listOf("A") * listOf(1, 2, 2))
    }

    @Test fun `Simple list multiplication returns each combination of pairs from lists`() {
        assertEquals(listOf("A" to 1, "A" to 2, "B" to 1, "B" to 2), listOf("A", "B") * listOf(1, 2))
    }

    @Test fun `Multiplication of tree lists is returning triple with each combination of each lists`() {
        assertEquals(listOf(
                Triple("A", 1, 'a'),
                Triple("A", 1, 'b'),
                Triple("A", 2, 'a'),
                Triple("A", 2, 'b'),
                Triple("B", 1, 'a'),
                Triple("B", 1, 'b'),
                Triple("B", 2, 'a'),
                Triple("B", 2, 'b')
        ), listOf("A", "B") * listOf(1, 2) * listOf('a', 'b'))
    }

    @Test fun `Size of result of list multipication is equeal to multiplication of list sizes`() {
        val list1 = (1..5).toList()
        val list2 = (1..10).toList()
        val list3 = (1..25).toList()
        assertEquals(list1.size * list2.size, (list1 * list2).size)
        assertEquals(list1.size * list3.size, (list1 * list3).size)
        assertEquals(list2.size * list3.size, (list2 * list3).size)
        assertEquals(list1.size * list1.size, (list1 * list1).size)
        assertEquals(list2.size * list2.size, (list2 * list2).size)
        assertEquals(list3.size * list3.size, (list3 * list3).size)
        assertEquals(list1.size * list2.size * list3.size, (list1 * list2 * list3).size)
        assertEquals(list1.size * list1.size * list1.size, (list1 * list1 * list1).size)
        assertEquals(list2.size * list2.size * list2.size, (list2 * list2 * list2).size)
        assertEquals(list3.size * list3.size * list3.size, (list3 * list3 * list3).size)
    }
}