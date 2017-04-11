package com.marcinmoskala.math

/**
 *  Permutations are all different ways to arrange elements from some collection (https://en.wikipedia.org/wiki/Permutation).
 *  For sets it's number is n!, for lists it is n! / (n1! * n2! * ...) where n1, n2... are numbers elements that are the same.
 */

/* This function returns number of all permutations of elements from set. It is equal to n! where n is size of set. */
fun <T> Set<T>.permutationNumber(): Long = factorial(size)

/* This function returns number of all permutations of elements from list. It is equal to n! / (n1! * n2! * ...) where n1, n2... are numbers elements that are the same. */
fun <T> List<T>.permutationNumber(): Long = if (size < 1) 0L else factorial(size) / groupBy { it }.map { factorial(it.value.size) }.product()

/* This function returns all permutations of elements from set. These are different ways to arrange elements from this list.  */
fun <T> Set<T>.allPermutations(): Set<List<T>> = toList().allPermutations()

/* This function returns all permutations of elements from list. These are different ways to arrange elements from this list.  */
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

private fun <T> List<T>.plusAt(index: Int, element: T): List<T> = when {
    index > size || index < 0 -> throw Error("Cannot put at index $index because size is $size")
    index == 0 -> listOf(element) + this
    index == size -> this + element
    else -> drop(index) + element + dropLast(size - index)
}