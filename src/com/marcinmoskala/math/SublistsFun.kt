package com.marcinmoskala.math

fun <T> Set<T>.subsets(): Set<Set<T>> = when {
    size <= 1 -> setOf(setOf<T>()).plusElement(this)
    else -> drop(1).toSet().subsets().let { it + it.map { it + first() } }
}