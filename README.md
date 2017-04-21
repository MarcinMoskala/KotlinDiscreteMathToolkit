# KotlinDiscreteMathToolkit
Set of extensions for Kotlin that provides Discrete Math functionalities as an Kotlin extension functions.

# Combinations

val subsetSize = 3
setOf(1, 2, 3, 4).combinations(subsetSize) // {{1, 2, 3}, {1, 2, 4}, {1, 4, 3}, {4, 2, 3}}
setOf(1, 2, 3, 4).combinationNumber(subsetSize) // 4

More examples [here](https://github.com/MarcinMoskala/KotlinDiscreteMathToolkit/blob/master/src/com/marcinmoskala/math/tests/com/marcinmoskala/math/tests/CombinationTest.kt)
