package com.marcinmoskala.math

fun <T> Set<T>.permutationNumber(): Int = factorial(size)

fun factorial(i: Int): Int = (1..i).product()

fun Collection<Int>.product() = if(isEmpty()) 0 else fold(1) { a, n -> a * n }

fun IntRange.product() = if(isEmpty()) 0 else fold(1) { a, n -> a * n }