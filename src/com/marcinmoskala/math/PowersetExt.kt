package com.marcinmoskala.math

fun <T> Collection<T>.powerset(): Set<Set<T>> = when {
    size <= 1 -> setOf(setOf<T>()).plusElement(this.toSet())
    else -> drop(1).toSet().powerset().let { it + it.map { it + first() } }
}

fun <T> Collection<T>.powersetSize(): Int = pow(2, size)