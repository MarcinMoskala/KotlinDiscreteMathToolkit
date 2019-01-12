@file:JvmName("DiscreteMath")
@file:JvmMultifileClass

package com.marcinmoskala.math

import java.math.BigDecimal
import java.math.BigInteger

infix fun Number.pow(power: Number): Double =
        Math.pow(this.toDouble(), power.toDouble())

infix fun Int.pow(power: Int): Int =
        Math.pow(this.toDouble(), power.toDouble()).toInt()