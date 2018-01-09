@file:JvmName("DiscreteMath")
@file:JvmMultifileClass
package com.marcinmoskala.math

infix fun Double.pow(other: Number): Double = Math.pow(this, other.toDouble())

infix fun Float.pow(other: Number): Float = Math.pow(this.toDouble(), other.toDouble()).toFloat()

infix fun Long.pow(other: Number): Long = Math.pow(this.toDouble(), other.toDouble()).toLong()

infix fun Int.pow(other: Number): Int = Math.pow(this.toDouble(), other.toDouble()).toInt()

infix fun Short.pow(other: Number): Short = Math.pow(this.toDouble(), other.toDouble()).toShort()

infix fun Byte.pow(other: Number): Byte = Math.pow(this.toDouble(), other.toDouble()).toByte()

// we have all Number types for pow that returns their types but this is for all that returns Double
infix fun Number.pow(other: Number): Double = Math.pow(this.toDouble(), other.toDouble())
