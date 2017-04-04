package com.marcinmoskala.math

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
                2..4 to 24,
                1..4 to 24,
                3..4 to 12,
                100..100 to 100
        )
        for ((range, product) in rangeToProduct)
            Assertions.assertEquals(product, range.product())
    }

    @Test
    fun `Test products of different Int Collections`() {
        val collectionToProduct = mapOf(
                listOf(1,2,3) to 6,
                listOf(2,3) to 6,
                listOf(3) to 3,
                listOf(10, 10, 10) to 1000
        )
        for ((collection, product) in collectionToProduct)
            Assertions.assertEquals(product, collection.product())
    }


}