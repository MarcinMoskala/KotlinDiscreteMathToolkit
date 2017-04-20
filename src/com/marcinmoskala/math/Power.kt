package com.marcinmoskala.math

fun pow(num: Int, power: Int): Int {
    return Math.pow(num.toDouble(), power.toDouble()).toInt()
}