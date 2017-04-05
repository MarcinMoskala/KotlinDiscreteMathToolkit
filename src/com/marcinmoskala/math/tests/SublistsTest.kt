package com.marcinmoskala.math.tests

import com.marcinmoskala.math.sublists
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SublistsTest {

    @Test fun `Sublists from empty list is always empty`() {
        val emptyList = listOf<Int>()
        assertEquals(emptyList, emptyList.sublists { true })
        assertEquals(emptyList, emptyList.sublists { false })
    }

}