package com.marcinmoskala.math

val <T> Set<T>.permutationNumber: Int get() = when {
    size == 0 -> 0
    else -> 1
}