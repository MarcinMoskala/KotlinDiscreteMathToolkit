package com.marcinmoskala.math

fun <T> Set<T>.permutationNumber(): Long = factorial(size)

fun <T> List<T>.permutationNumber(): Long = if(size < 1) 0L else factorial(size) / groupBy { it }.map { factorial(it.value.size) }.product()

fun <T> Set<T>.allPermutations(): Set<List<T>> = toList().allPermutations()

fun <T> List<T>.allPermutations(): Set<List<T>> {
    if(isEmpty()) return setOf()
    val element = get(0)
    if(size == 1) return setOf(listOf(element))
    val other = drop(1).allPermutations()
    return other.flatMap { sublist -> (0..sublist.size).map { i -> sublist.plusAt(i, element) } }.toSet()
}

fun <T> List<T>.plusAt(index: Int, element: T): List<T> = when {
    index > size || index < 0 -> throw Error("Cannot put at index $index because size is $size")
    index == 0 -> listOf(element) + this
    index == size -> this + element
    else -> drop(index) + element + dropLast(size - index)
}

fun factorial(i: Int): Long = (1..i).product()

fun Collection<Int>.product(): Long = if(isEmpty()) 0L else fold(1L) { a, n -> a * n }

@JvmName("ProductOfLongCollection") fun Collection<Long>.product(): Long = if(isEmpty()) 0L else fold(1L) { a, n -> a * n }

fun IntRange.product(): Long = if(isEmpty()) 0L else fold(1L) { a, n -> a * n }