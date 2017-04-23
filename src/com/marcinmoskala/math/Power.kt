package com.marcinmoskala.math

fun Int.pow(power: Int): Int {
    return Math.pow(this.toDouble(), power.toDouble()).toInt()
}

fun Int.pow(power: Double): Int {
    return Math.pow(this.toDouble(), power).toInt()
}