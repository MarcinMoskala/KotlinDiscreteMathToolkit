package com.marcinmoskala.math

fun <T> Set<T>.permutationNumber(): Long = factorial(size)

fun <T> List<T>.permutationNumber(): Long = if(size < 1) 0L else factorial(size) / groupBy { it }.map { factorial(it.value.size) }.product()

fun factorial(i: Int): Long = (1..i).product()

fun Collection<Int>.product(): Long = if(isEmpty()) 0L else fold(1L) { a, n -> a * n }

@JvmName("ProductOfLongCollection") fun Collection<Long>.product(): Long = if(isEmpty()) 0L else fold(1L) { a, n -> a * n }

fun IntRange.product(): Long = if(isEmpty()) 0L else fold(1L) { a, n -> a * n }