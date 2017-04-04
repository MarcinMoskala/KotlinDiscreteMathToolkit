package com.marcinmoskala.math.tests

import com.marcinmoskala.math.product
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class ProductTest {

    @Test
    fun `Product of empty IntRange is 0`() {
        Assertions.assertEquals(0, (1..0).product())
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
            Assertions.assertEquals(product, range.product())
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
            Assertions.assertEquals(product, collection.product())
    }
}