package com.marcinmoskala.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class ProductTest {
    @Test
    fun `Product of empty IntRange is 0`() {
        Assertions.assertEquals(0, (1..0).product())
    }

}