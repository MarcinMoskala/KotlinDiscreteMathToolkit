package com.marcinmoskala.math

fun Collection<Int>.product(): Long
        = if (isEmpty()) 0L else fold(1L) { a, n -> a * n }

@JvmName("ProductOfLongCollection")
fun Collection<Long>.product(): Long
        = if (isEmpty()) 0L else fold(1L) { a, n -> a * n }

fun IntRange.product(): Long
        = if (isEmpty()) 0L else fold(1L) { a, n -> a * n }