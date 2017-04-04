package com.marcinmoskala.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class ProductTest {

    val setToProduct = mapOf(
            listOf(1,2,3) to 6
    )

    @Test
    fun `Product of empty IntRange is 0`() {
        Assertions.assertEquals(0, (1..0).product())
    }

    @Test
    fun `Test products of different IntRanges`() {
        val rangeToProduct = mapOf(2..4 to 24, 1..4 to 24, 3..4 to 12, 100..100 to 100)
        for ((range, product) in rangeToProduct)
            Assertions.assertEquals(product, range.product())
    }
}