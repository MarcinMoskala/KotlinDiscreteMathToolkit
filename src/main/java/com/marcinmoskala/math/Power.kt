@file:JvmName("DiscreteMath")
@file:JvmMultifileClass
package com.marcinmoskala.math

fun Int.pow(power: Int): Int {
    return Math.pow(this.toDouble(), power.toDouble()).toInt()
}