package com.marcinmoskala.math

// Stirling function - number of splits of n different elements to k groups
fun <T> Set<T>.splitsNumber(groupsNum: Int): Int = when {
    groupsNum == 0 -> if (isEmpty()) 1 else 0
    groupsNum == 1 || groupsNum == size -> 1
    groupsNum > size -> 0
    else -> (1..(size - 1)).toSet().splitsNumber(groupsNum - 1) + groupsNum * (1..(size - 1)).toSet().splitsNumber(groupsNum)
}

// Takes set of elements and returns set of splits and each of them is set of sets
fun <T> Set<T>.splits(groupsNum: Int): Set<Set<Set<T>>> = when {
    groupsNum == 0 -> if (isEmpty()) setOf(emptySet()) else emptySet()
    groupsNum == 1 -> setOf(setOf(this))
    groupsNum == size -> setOf(this.map { setOf(it) }.toSet())
    groupsNum > size -> emptySet()
    else -> setOf<Set<Set<T>>>()
            .plus(this.minusElement(first())  // Element is alone in the group
                    .splits(groupsNum - 1)
                    .map { it.plusElement(setOf(first())) }) // We are adding group with one element
            .plus(this.minusElement(first())  // Element is not alone in the group
                    .splits(groupsNum)
                    .flatMap { split -> split.map { group -> split.minusElement(group).plusElement(group + first()) } }) // We are adding element to different groups
}

// Number of splits of n identical elements to k groups
fun Int.splitsNumber(groupsNum: Int): Int = when {
    groupsNum == 0 -> if (this == 0) 1 else 0
    groupsNum == 1 || groupsNum == this -> 1
    groupsNum > this -> 0
    else -> (1..groupsNum).sumBy { i -> (this - groupsNum).splitsNumber(i) }
}