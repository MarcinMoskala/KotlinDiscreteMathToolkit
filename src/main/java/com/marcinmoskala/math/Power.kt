@file:JvmName("DiscreteMath")
@file:JvmMultifileClass
package com.marcinmoskala.math

infix fun Int.pow(power: Int): Int = Math.pow(this.toDouble(), power.toDouble()).toInt()
