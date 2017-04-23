package com.marcinmoskala.math

// Stirling function - number of splits of n different elements to k groups
fun <T> Set<T>.splitsNumber(groupsNum: Int): Int = when {
    groupsNum == 0 -> if (isEmpty()) 1 else 0
    groupsNum == 1 || groupsNum == size -> 1
    groupsNum > size -> 0
    else -> (1..(size - 1)).toSet().splitsNumber(groupsNum - 1) + groupsNum * (1..(size - 1)).toSet().splitsNumber(groupsNum)
}

fun <T> Set<T>.splits(groupsNum: Int): Set<Set<T>> = when {
    groupsNum ==  0 -> if(isEmpty()) setOf(emptySet()) else emptySet()
    groupsNum == 1 -> setOf(this)
    else -> setOf()
}

// Number of splits of n identical elements to k groups
fun Int.splitsNumber(groupsNum: Int): Int = when {
    groupsNum == 0 -> if (this == 0) 1 else 0
    groupsNum == 1 || groupsNum == this -> 1
    groupsNum > this -> 0
    else -> (1..groupsNum).sumBy { i -> (this - groupsNum).splitsNumber(i) }
}