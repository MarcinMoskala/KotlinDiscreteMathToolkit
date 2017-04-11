package com.marcinmoskala.math

fun <T> List<T>.sublistsBySplitters(isSplitter: (T) -> Boolean): List<List<T>> = when {
    size == 0 -> listOf(listOf())
    none { isSplitter(it) } -> listOf(this)
    size == 1 -> listOf(this, listOf())
    isSplitter(last()) -> sublistFromRest(isSplitter)
            .flatMap { listOf(it + last(), it) }
    else -> sublistFromRest(isSplitter)
            .map { it + last() }
}

private fun <T> List<T>.sublistFromRest(isSplitter: (T) -> Boolean) = dropLast(1).sublistsBySplitters(isSplitter)