package com.marcinmoskala.math.tests

import com.marcinmoskala.math.cartesianProduct
import io.kotest.core.spec.style.StringSpec
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.list
import io.kotest.property.forAll


@ExperimentalStdlibApi
internal class CartesianProductPropertyTest : StringSpec({

    val intListGen = Arb.list(
            Arb.int(0..100),
            2..5
    )

    val listOfIntListsGen = Arb.list(
            intListGen,
            2..5
    )


    "output product size is product of sizes of inputs" {
        forAll(listOfIntListsGen) { list ->
            val head = list[0]
            val tail = list.drop(1).toTypedArray()
            head.cartesianProduct(*tail).toList().size == list.map { it.size }.reduce(Int::times)
        }
    }

    "cartesian product with repeat of empty list is empty list" {
        forAll(Arb.int(2..10)) { repeat ->
            emptyList<Int>().cartesianProduct(repeat).toList().isEmpty()
        }
    }

    "cartesian product of empty list and non empty list is empty list" {
        forAll(intListGen) { list ->
            emptyList<Int>().cartesianProduct(list).toList().isEmpty()
        }
    }

    "cartesian product of non empty list and empty list is empty list" {
        forAll(intListGen) { list ->
            list.cartesianProduct(emptyList()).toList().isEmpty()
        }
    }

    "set of elements in product is the same as in input" {
        forAll(listOfIntListsGen) { list ->
            val head = list[0]
            val tail = list.drop(1).toTypedArray()
            head.cartesianProduct(*tail).toList().flatten().toSet() ==
                    list.flatten().toSet()
        }
    }

//    TODO:
//    - test "A","B" * 1,2 (heterogenous lists)
//    - make sure prop test run on build
//    - rewrite implementation to not use deck
//    - README

})