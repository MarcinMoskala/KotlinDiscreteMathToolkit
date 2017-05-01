package com.marcinmoskala.math

fun <T> Collection<T>.powerset(): Set<Set<T>> = when {
    size <= 1 -> setOf(setOf(), this.toSet())
    else -> drop(1).toSet().powerset().let { it + it.map { it + first() } }
}

val <T> Collection<T>.powersetSize: Int
    get() = 2.pow(size)