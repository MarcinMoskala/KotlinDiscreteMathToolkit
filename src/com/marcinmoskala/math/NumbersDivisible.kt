package com.marcinmoskala.math

fun IntRange.divisiveBy(vararg numbers: Int)
        = filter { n -> numbers.any { n % it == 0 } }

fun IntRange.countDivisiveBy(vararg numbers: Int)
        = count { n -> numbers.any { n % it == 0 } }

fun IntRange.nonDivisiveBy(vararg numbers: Int)
        = filter { n -> numbers.all { n % it != 0 } }

fun IntRange.countNonDivisiveBy(vararg numbers: Int)
        = count { n -> numbers.all { n % it != 0 } }