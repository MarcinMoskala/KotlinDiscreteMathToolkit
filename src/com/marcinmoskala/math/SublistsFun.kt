package com.marcinmoskala.math

fun <T> Set<T>.subsets(): Set<Set<T>> = when {
    size == 0 -> setOf(setOf())
    size == 1 -> setOf(this, setOf())
    else -> drop(1).toSet().subsets().let { it + it.map { it + first() } }
}