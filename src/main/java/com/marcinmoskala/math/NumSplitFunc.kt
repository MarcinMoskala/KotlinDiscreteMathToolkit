@file:JvmName("DiscreteMath")
@file:JvmMultifileClass
package com.marcinmoskala.math

// Number of splits of n identical elements to k groups
fun Int.splitsNumber(groupsNum: Int): Int = when {
    groupsNum == 0 -> if (this == 0) 1 else 0
    groupsNum == 1 || groupsNum == this -> 1
    groupsNum > this -> 0
    else -> (1..groupsNum).sumBy { i -> (this - groupsNum).splitsNumber(i) }
}

