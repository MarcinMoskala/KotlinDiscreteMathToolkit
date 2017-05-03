package com.marcinmoskala.math

operator fun <T, R> List<T>.times(l: List<R>): List<Pair<T, R>> = flatMap { e1 -> l.map { e2 -> e1 to e2 } }