package com.marcinmoskala.math

/**
 * In mathematics, a combination is a way of selecting items from a collection, such that (unlike permutations) the
 * order of selection does not matter.
 *
 * For set {1, 2, 3}, 2 elements combinations are {1, 2}, {2, 3}, {1, 3}.
 * All possible combinations is called 'powerset' and can be found as an
 * extension function for set under this name
 */
fun <T> Set<T>.combinations(combinationSize: Int): Set<Set<T>> = when {
    combinationSize <= 0 -> setOf()
    combinationSize >= size -> setOf(toSet())
    else -> powerset()
            .filter { it.size == combinationSize }
            .toSet()
}

fun <T> Set<T>.combinationNumber(combinationSize: Int): Long = when {
    combinationSize >= size -> 1
    combinationSize <= 0 -> 0
    else -> factorial(size) / (factorial(combinationSize) * factorial(size - combinationSize))
}