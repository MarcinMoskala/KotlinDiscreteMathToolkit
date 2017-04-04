package com.marcinmoskala.math

fun <T> Set<T>.permutationNumber(): Int = (1..size).product()

fun Collection<Int>.product() = if(isEmpty()) 0 else fold(1) { a, n -> a * n }

fun IntRange.product() = if(isEmpty()) 0 else fold(1) { a, n -> a * n }