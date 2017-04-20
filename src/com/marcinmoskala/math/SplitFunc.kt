package com.marcinmoskala.math

// S(n, k) - Stirling function - number of splits of n different elements to k groups
fun S(elements: Int, parts: Int): Int = when {
    parts == 0 -> if (elements == 0) 1 else 0
    parts == 1 || parts == elements -> 1
    parts > elements -> 0
    else -> S(elements - 1, parts - 1) + parts * S(elements - 1, parts)
}

// P(n, k) - number of splits of n identical elements to k groups
fun P(elements: Int, parts: Int): Int = when {
    parts == 0 -> if (elements == 0) 1 else 0
    parts == 1 || parts == elements -> 1
    parts > elements -> 0
    else -> (1..parts).sumBy { i -> P(elements - parts, i) }
}