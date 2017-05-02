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
    combinationSize < 0 -> setOf()
    combinationSize == 0 -> setOf(setOf())
    combinationSize >= size -> setOf(toSet())
    else -> powerset()
            .filter { it.size == combinationSize }
            .toSet()
}

fun <T> Set<T>.combinationsNumber(combinationSize: Int): Long = when {
    combinationSize >= size || combinationSize == 0 -> 1
    combinationSize < 0 -> 0
    else -> size.factorial() / (combinationSize.factorial() * (size - combinationSize).factorial())
}

fun <T> Set<T>.combinationsWithRepetitions(combinationSize: Int): Set<Map<T, Int>> = when {
    combinationSize < 0 -> setOf()
    combinationSize == 0 -> setOf(mapOf())
    else -> combinationsWithRepetitions(combinationSize - 1)
            .flatMap { subset -> this.map { subset + (it to (subset.getOrElse(it) { 0 } + 1)) } }
            .toSet()
}

fun <T> Set<T>.combinationsWithRepetitionsNumber(combinationSize: Int): Long = when {
    combinationSize == 0 -> 1
    combinationSize < 0 -> 0
    else -> (size + combinationSize - 1).factorial() / (combinationSize.factorial() * (size - 1).factorial())
}