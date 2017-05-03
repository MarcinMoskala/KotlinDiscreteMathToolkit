@file:JvmName("DiscreteMath")
@file:JvmMultifileClass
package com.marcinmoskala.math

fun Iterable<Int>.product(): Long = fold(1L) { a, n -> a * n }

@JvmName("productLong")
fun Collection<Long>.product(): Long = fold(1L) { a, n -> a * n }