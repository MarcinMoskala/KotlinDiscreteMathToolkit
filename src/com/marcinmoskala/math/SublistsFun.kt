package com.marcinmoskala.math

fun <T> Set<T>.powerSet(): Set<Set<T>> = when {
    size <= 1 -> setOf(setOf<T>()).plusElement(this)
    else -> drop(1).toSet().powerSet().let { it + it.map { it + first() } }
}

fun  List<Int>.sublists(): Set<List<Int>> = when {
    isEmpty() -> setOf(emptyList())
    else -> flatMap { listOf(this) + (this - it).sublists() }.toSet()
}

private fun measureTime(f: () -> Unit) {
    val startTime = System.currentTimeMillis()
    f()
    val endTime = System.currentTimeMillis()
    println("It took " + (endTime - startTime))
}

fun main(args: Array<String>) {
    val range = (1..10)
    measureTime { range.toSet().powerSet() }
    measureTime { range.toList().sublists() }
}