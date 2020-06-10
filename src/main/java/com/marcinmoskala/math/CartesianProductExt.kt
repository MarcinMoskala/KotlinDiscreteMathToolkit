@file:JvmName("DiscreteMath")
@file:JvmMultifileClass

package com.marcinmoskala.math

@ExperimentalStdlibApi
fun <T> List<T>.cartesianProduct(repeat: Int = 2): Sequence<List<T>> {
    require(repeat > 0) { "Parameter repeat should be greater than 0" }
    return productEx(*Array(repeat) { this })
}

@ExperimentalStdlibApi
fun <T> List<T>.cartesianProduct(vararg lists: List<T>): Sequence<List<T>> =
        productEx(this, *lists)

@ExperimentalStdlibApi
private fun <T> productEx(vararg iterables: List<T>): Sequence<List<T>> = sequence {
    val numberOfIterables = iterables.size
    val lstLengths = ArrayDeque<Int>()
    val lstRemaining = ArrayDeque(listOf(1))

    iterables.reversed().forEach {
        lstLengths.addFirst(it.size)
        lstRemaining.addFirst(it.size * lstRemaining[0])
    }

    val nProducts = lstRemaining.removeFirst()

    (0 until nProducts).forEach { product ->
        val result = ArrayDeque<T>()
        (0 until numberOfIterables).forEach { iterableIndex ->
            val elementIndex = product / lstRemaining[iterableIndex] % lstLengths[iterableIndex]
            result.addLast(iterables[iterableIndex][elementIndex])
        }
        yield(result.toList())
    }
}