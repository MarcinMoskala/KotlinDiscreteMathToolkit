package com.marcinmoskala.math

fun <T> List<T>.plusAt(index: Int, element: T): List<T> = when {
    index > size || index < 0 -> throw Error("Cannot put at index $index because size is $size")
    index == 0 -> listOf(element) + this
    index == size -> this + element
    else -> drop(index) + element + dropLast(size - index)
}

fun factorial(i: Int): Long = (1..i).product()