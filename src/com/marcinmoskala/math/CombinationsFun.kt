package com.marcinmoskala.math

fun <T> Set<T>.combinationNumber(combinationSize: Int): Long = when {
    combinationSize >= size -> 1
    combinationSize <= 0 -> 0
    else -> factorial(size) / (factorial(combinationSize) * factorial(size - combinationSize))
}

fun <T> Set<T>.allCombinations(combinationSize: Int): Set<Set<T>> = when {
    combinationSize <= 0 -> setOf()
    combinationSize >= size -> setOf(toSet())
    else -> toList()
            .sublistsBySplitters { true }
            .filter { it.size == combinationSize }
            .map { it.toSet() }
            .toSet()
}