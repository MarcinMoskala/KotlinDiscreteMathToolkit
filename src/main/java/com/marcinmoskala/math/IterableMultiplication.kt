package com.marcinmoskala.math

operator fun <T, R> List<T>.times(l: List<R>): List<Pair<T, R>> = flatMap { e1 -> l.map { e2 -> e1 to e2 } }

@JvmName("listOfPairTimes")
operator fun <T, P, R> List<Pair<T, P>>.times(l: List<R>): List<Triple<T, P, R>> = flatMap { (e1, e2) -> l.map { e3 -> Triple(e1, e2, e3) } }