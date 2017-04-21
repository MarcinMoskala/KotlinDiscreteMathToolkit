# KotlinDiscreteMathToolkit
Set of extensions for Kotlin that provides Discrete Math functionalities as an Kotlin extension functions.

# Permutations

```kotlin
setOf(1, 2, 3).permutations() // {[1, 2, 3], [2, 1, 3], [3, 2, 1], [1, 3, 2], [2, 3, 1], [3, 1, 2]}
setOf(1, 2, 3).permutationNumber() // 6
listOf(1, 2, 2).permutations() // {[1, 2, 2], [2, 1, 2], [2, 2, 1]}
listOf(1, 2, 2).permutationNumber() // 3
```

More examples [here](https://github.com/MarcinMoskala/KotlinDiscreteMathToolkit/blob/master/src/com/marcinmoskala/math/tests/com/marcinmoskala/math/tests/PermutationTest.kt)

# Combinations

```kotlin
val subsetSize = 3
setOf(1, 2, 3, 4).combinations(subsetSize) // {{1, 2, 3}, {1, 2, 4}, {1, 4, 3}, {4, 2, 3}}
setOf(1, 2, 3, 4).combinationNumber(subsetSize) // 4

setOf(1, 2, 3, 4).combinationsWithRepetitions(2) // [{1=2}, {1=1, 2=1}, {1=1, 3=1}, {1=1, 4=1}, {2=2}, {2=1, 3=1}, {2=1, 4=1}, {3=2}, {3=1, 4=1}, {4=2}]
setOf(1, 2, 3, 4).combinationsWithRepetitionsNumber(2) // 10
```

More examples [here](https://github.com/MarcinMoskala/KotlinDiscreteMathToolkit/blob/master/src/com/marcinmoskala/math/tests/com/marcinmoskala/math/tests/CombinationTest.kt) and [here](https://github.com/MarcinMoskala/KotlinDiscreteMathToolkit/blob/master/src/com/marcinmoskala/math/tests/com/marcinmoskala/math/tests/CombinationWithRepetitionTest.kt)

# Powerset
Powerset of any set S is the set of all subsets of S, including the empty set and S itself.

```kotlin
setOf(1, 2, 3).powerset() // {{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}
setOf(1, 2, 3).powersetSize() // 8
```
# Product
Product is the result of multiplying. 

```kotlin
(3..4).product() // 12
listOf(10, 10, 10).product() // 1000
```

More examples [here](https://github.com/MarcinMoskala/KotlinDiscreteMathToolkit/blob/master/src/com/marcinmoskala/math/tests/com/marcinmoskala/math/tests/ProductTest.kt).

# Factorial
Factorian of n (n!) is a product of all positive integers less than or equal to n. 

```kotlin
factorial(3) // 6L
factorial(10) // 3628800L
factorial(20) // 2432902008176640000L
```
More examples [here](https://github.com/MarcinMoskala/KotlinDiscreteMathToolkit/blob/master/src/com/marcinmoskala/math/tests/com/marcinmoskala/math/tests/FactorialTest.kt).

# Numbers divisible and non-divisible by

```kotlin
(1..1000).countNonDivisiveBy(2) // 500
(1..1000).countNonDivisiveBy(3) // 777
(1..1000).countNonDivisiveBy(2, 6, 13) // 462
(1..1000).countNonDivisiveBy(3, 7, 11) // 520

(1..1000).countDivisiveBy(2) // 500
(1..1000).countDivisiveBy(3) // 333
(1..1000).countDivisiveBy(2, 6, 13) // 538
(1..1000).countDivisiveBy(3, 7, 11) // 480
```
More examples [here](https://github.com/MarcinMoskala/KotlinDiscreteMathToolkit/blob/master/src/com/marcinmoskala/math/tests/com/marcinmoskala/math/tests/NumbersDivisibleTest.kt).

# Splits of sets and numbers
In Descrete Math there are two functions used to count number of splits:
S(n, k) - Stirling function - number of splits of n different elements to k groups
P(n, k) - number of splits of n identical elements to k groups

```kotlin
S(n, 1) // 1
S(n, n) // 1
S(3, 2) // 3
S(4, 2) // 7
S(5, 3) // 25
S(7, 4) // 350
```

More examples [here](https://github.com/MarcinMoskala/KotlinDiscreteMathToolkit/blob/master/src/com/marcinmoskala/math/tests/com/marcinmoskala/math/tests/SetSplitTest.kt)

```kotlin
P(n, 1) // 1
P(n, n) // 1
P(7, 4) // 3
P(11, 4) // 11
P(9, 5) // 5
P(13, 8) // 7
```

More examples [here](https://github.com/MarcinMoskala/KotlinDiscreteMathToolkit/blob/master/src/com/marcinmoskala/math/tests/com/marcinmoskala/math/tests/NumberSplitTest.kt)
