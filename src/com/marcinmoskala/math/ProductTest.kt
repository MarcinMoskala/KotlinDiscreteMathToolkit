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
    fun `Product of 2 to 4 is 24`() {
        Assertions.assertEquals(24, (2..4).product())
    }


}