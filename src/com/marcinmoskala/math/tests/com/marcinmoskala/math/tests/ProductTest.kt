package com.marcinmoskala.math.tests

import com.marcinmoskala.math.product
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ProductTest {

    @Test
    fun `Product of empty IntRange is 0`() {
        assertEquals(0, (1..0).product())
    }

    @Test
    fun `Test products of different IntRanges`() {
        val rangeToProduct = mapOf(
                2..4 to 24L,
                1..4 to 24L,
                3..4 to 12L,
                100..100 to 100L
        )
        for ((range, product) in rangeToProduct)
            assertEquals(product, range.product())
    }

    @Test
    fun `Test products of different Int Collections`() {
        val collectionToProduct = mapOf(
                listOf(1,2,3) to 6L,
                listOf(2,3) to 6L,
                listOf(3) to 3L,
                listOf(10, 10, 10) to 1000L
        )
        for ((collection, product) in collectionToProduct)
            assertEquals(product, collection.product())
    }

    @Test
    fun `Test products of different Long Collections`() {
        val collectionToProduct = mapOf(
                listOf(1L,2L,3L) to 6L,
                listOf(2L,3L) to 6L,
                listOf(3L) to 3L,
                listOf(10L, 10L, 10L) to 1000L
        )
        for ((collection, product) in collectionToProduct)
            assertEquals(product, collection.product())
    }
}