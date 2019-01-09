@file:JvmName("DiscreteMath")
@file:JvmMultifileClass
package com.marcinmoskala.math

import java.math.BigDecimal
import java.math.BigInteger

infix fun Number.pow(power: Number): Double = Math.pow(this.toDouble(), power.toDouble())

infix fun BigInteger.pow(power: BigInteger): BigInteger = pow(power).toBigInteger()

infix fun BigDecimal.pow(power: BigDecimal): BigDecimal = pow(power).toBigDecimal()

infix fun Double.pow(power: Double): Double = pow(power)

infix fun Long.pow(power: Long): Long = pow(power).toLong()

infix fun Int.pow(power: Int): Int = pow(power).toInt()

infix fun Short.pow(power: Short): Short = pow(power).toShort()

infix fun Byte.pow(power: Byte): Byte = pow(power).toByte()
