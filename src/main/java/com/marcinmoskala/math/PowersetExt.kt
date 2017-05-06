@file:JvmName("DiscreteMath")
@file:JvmMultifileClass
package com.marcinmoskala.math

fun <T> Collection<T>.powerset(): Set<Set<T>> = when {
    set.isEmpty() -> setOf(setOf())
    else -> drop(1).powerset().let { it + it.map { it + first() } }
}

val <T> Collection<T>.powersetSize: Int
    get() = 2.pow(size)