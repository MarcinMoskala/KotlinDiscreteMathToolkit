@file:JvmName("DiscreteMath")
@file:JvmMultifileClass
package com.marcinmoskala.math

/**
 *  Permutations are all different ways to arrange elements from some collection (https://en.wikipedia.org/wiki/Permutation).
 *  For sets it's number is n!, for lists it is n! / (n1! * n2! * ...) where n1, n2... are numbers elements that are the same.
 */

/* This function returns number of all permutations of elements from set. It is equal to n! where n is size of set. */
fun <T> Set<T>.permutationsNumber(): Long = size.factorial()

/* This function returns number of all permutations of elements from list. It is equal to n! / (n1! * n2! * ...) where n1, n2... are numbers elements that are the same. */
fun <T> List<T>.permutationsNumber(): Long = if (size < 1) 1L else size.factorial() / groupBy { it }.map { it.value.size.factorial() }.product()

/* This function returns all permutations of elements from set. These are different ways to arrange elements from this list.  */
fun <T> Set<T>.permutations(): Set<List<T>> = toList().permutations()

/* This function returns all permutations of elements from list. These are different ways to arrange elements from this list.  */
fun <T> List<T>.permutations(): Set<List<T>> = when {
    isEmpty() -> setOf()
    size == 1 -> setOf(listOf(get(0)))
    else -> {
        val element = get(0)
        drop(1).permutations()
                .flatMap { sublist -> (0..sublist.size).map { i -> sublist.plusAt(i, element) } }
                .toSet()
    }
}

private fun <T> List<T>.plusAt(index: Int, element: T): List<T> = when {
    index !in 0..size -> throw Error("Cannot put at index $index because size is $size")
    index == 0 -> listOf(element) + this
    index == size -> this + element
    else -> dropLast(size - index) + element + drop(index)
}