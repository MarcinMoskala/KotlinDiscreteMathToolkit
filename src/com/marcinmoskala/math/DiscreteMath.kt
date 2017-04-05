package com.marcinmoskala.math

fun <T> Set<T>.permutationNumber(): Long = factorial(size)

fun <T> Set<T>.combinationNumber(combinationSize: Int): Long = when {
    combinationSize >= size -> 1
    combinationSize <= 0 -> 0
    else -> factorial(size) / (factorial(combinationSize) * factorial(size - combinationSize))
}

fun <T> Set<T>.allCombinations(combinationSize: Int): Set<Set<T>> = when {
    combinationSize <= 0 -> setOf()
    combinationSize >= size -> setOf(toSet())
    else -> toList()
            .sublists { true }
            .filter { it.size == combinationSize }
            .map { it.toSet() }
            .toSet()
}

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

fun <T> List<T>.plusAt(index: Int, element: T): List<T> = when {
    index > size || index < 0 -> throw Error("Cannot put at index $index because size is $size")
    index == 0 -> listOf(element) + this
    index == size -> this + element
    else -> drop(index) + element + dropLast(size - index)
}

fun factorial(i: Int): Long = (1..i).product()

fun Collection<Int>.product(): Long = if (isEmpty()) 0L else fold(1L) { a, n -> a * n }

@JvmName("ProductOfLongCollection") fun Collection<Long>.product(): Long = if (isEmpty()) 0L else fold(1L) { a, n -> a * n }

fun IntRange.product(): Long = if (isEmpty()) 0L else fold(1L) { a, n -> a * n }