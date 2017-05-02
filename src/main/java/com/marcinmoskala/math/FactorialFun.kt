@file:JvmName("DiscreteMath")
@file:JvmMultifileClass
package com.marcinmoskala.math

fun Int.factorial(): Long = (1..this).product()