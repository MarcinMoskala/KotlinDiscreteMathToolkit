package com.marcinmoskala.math.tests

import com.marcinmoskala.math.cartesianProduct
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.next
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals


internal class CartesianProductTest {

    @Test
    fun `cartesian product with size more than MAX_INT throws`() {
        assertThrows(IllegalArgumentException::class.java) {
            listOf(1, 2, 3, 5, 6, 7, 8, 9, 0).cartesianProduct(10).toList()
        }
    }

    @Test
    fun `cartesian product with repeat less than 1 throws`() {
        val repeat = Arb.int(-100..0).next()
        assertThrows(IllegalArgumentException::class.java) {
            listOf(1, 2, 3).cartesianProduct(repeat)
        }
    }

    @Test
    fun `cartesian product with repeat = 1`() {
        val actual = listOf(1, 2, 3).cartesianProduct(1).toList()
        val expected = listOf(
                listOf(1),
                listOf(2),
                listOf(3)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `cartesian product with repeat`() {
        val actual = listOf(1, 2, 3).cartesianProduct(2).toList()
        val expected = listOf(
                listOf(1, 1),
                listOf(1, 2),
                listOf(1, 3),
                listOf(2, 1),
                listOf(2, 2),
                listOf(2, 3),
                listOf(3, 1),
                listOf(3, 2),
                listOf(3, 3)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `cartesian product of different sizes`() {
        val actual = listOf(1, 2, 3).cartesianProduct(listOf(8, 9)).toList()
        val expected = listOf(
                listOf(1, 8),
                listOf(1, 9),
                listOf(2, 8),
                listOf(2, 9),
                listOf(3, 8),
                listOf(3, 9)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `cartesian product of same sizes`() {
        val actual = listOf(1, 2).cartesianProduct(listOf(8, 9)).toList()
        val expected = listOf(
                listOf(1, 8),
                listOf(1, 9),
                listOf(2, 8),
                listOf(2, 9)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `cartesian product of 3 lists`() {
        val actual = listOf(1, 2).cartesianProduct(
                listOf(3, 4),
                listOf(5, 6)
        ).toList()
        val expected = listOf(
                listOf(1, 3, 5),
                listOf(1, 3, 6),
                listOf(1, 4, 5),
                listOf(1, 4, 6),
                listOf(2, 3, 5),
                listOf(2, 3, 6),
                listOf(2, 4, 5),
                listOf(2, 4, 6)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `cartesian product of 3 lists with different size`() {
        val actual = listOf(0, 1, 2).cartesianProduct(
                listOf(3, 4),
                listOf(5, 6)
        ).toList()
        val expected = listOf(
                listOf(0, 3, 5),
                listOf(0, 3, 6),
                listOf(0, 4, 5),
                listOf(0, 4, 6),
                listOf(1, 3, 5),
                listOf(1, 3, 6),
                listOf(1, 4, 5),
                listOf(1, 4, 6),
                listOf(2, 3, 5),
                listOf(2, 3, 6),
                listOf(2, 4, 5),
                listOf(2, 4, 6)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `cartesian product of 2 lists with different types`() {
        val expected = listOf(
                listOf("A", 1),
                listOf("A", 2),
                listOf("A", 3),
                listOf("B", 1),
                listOf("B", 2),
                listOf("B", 3)
        )
        val actual = listOf("A", "B").cartesianProduct(listOf(1, 2, 3)).toList()
        assertEquals(expected, actual)
    }
}