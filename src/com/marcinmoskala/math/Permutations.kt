package com.marcinmoskala.math

fun <T> Set<T>.permutationNumber(): Long = factorial(size)

fun <T> List<T>.permutationNumber(): Long = if (size < 1) 0L else factorial(size) / groupBy { it }.map { factorial(it.value.size) }.product()

fun <T> Set<T>.allPermutations(): Set<List<T>> = toList().allPermutations()

fun <T> List<T>.allPermutations(): Set<List<T>> = when {
    isEmpty() -> setOf()
    size == 1 -> setOf(listOf(get(0)))
    else -> {
        val element = get(0)
        drop(1).allPermutations()
                .flatMap { sublist -> (0..sublist.size).map { i -> sublist.plusAt(i, element) } }
                .toSet()
    }
}