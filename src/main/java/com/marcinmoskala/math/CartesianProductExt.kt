@file:JvmName("DiscreteMath")
@file:JvmMultifileClass

package com.marcinmoskala.math

/**
 * Cartesian product of a list with itself, specify the number of repetitions with the optional repeat keyword argument.
 * For example, A.cartesianProduct(repeat=4) means the same as A.cartesianProduct(A, A, A).
 * Throws an [IllegalArgumentException]: if [repeat] is less or equals to 0
 * Throws an [IllegalArgumentException]: if size of result should exceeds [Int.MAX_VALUE]
 */
fun <T> List<T>.cartesianProduct(repeat: Int = 2): Sequence<List<T>> {
    require(repeat > 0) { "Parameter repeat should be greater than 0" }
    return product(*Array(repeat) { this })
}

/**
 * Cartesian product of lists.
 * Throws an [IllegalArgumentException]: if size of result should exceeds [Int.MAX_VALUE]
 */
fun <T> List<T>.cartesianProduct(vararg lists: List<T>): Sequence<List<T>> =
        product(this, *lists)

private fun <T> product(vararg iterables: List<T>): Sequence<List<T>> = sequence {

    require(iterables.map { it.size.toLong() }.reduce(Long::times) <= Int.MAX_VALUE) {
        "Cartesian product function can produce result whose size does not exceed Int.MAX_VALUE"
    }

    val numberOfIterables = iterables.size
    val lstLengths = ArrayList<Int>()
    val lstRemaining = ArrayList(listOf(1))

    iterables.reversed().forEach {
        lstLengths.add(0, it.size)
        lstRemaining.add(0, it.size * lstRemaining[0])
    }

    val nProducts = lstRemaining.removeAt(0)

    (0 until nProducts).forEach { product ->
        val result = ArrayList<T>()
        (0 until numberOfIterables).forEach { iterableIndex ->
            val elementIndex = product / lstRemaining[iterableIndex] % lstLengths[iterableIndex]
            result.add(iterables[iterableIndex][elementIndex])
        }
        yield(result.toList())
    }
}