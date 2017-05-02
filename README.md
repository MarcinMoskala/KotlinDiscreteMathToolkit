# KotlinDiscreteMathToolkit
Set of extensions for Kotlin that provides Discrete Math functionalities as an Kotlin extension functions.

# Permutations

```kotlin
setOf(1, 2, 3).permutations() // {[1, 2, 3], [2, 1, 3], [3, 2, 1], [1, 3, 2], [2, 3, 1], [3, 1, 2]}
setOf(1, 2, 3).permutationsNumber() // 6
listOf(1, 2, 2).permutations() // {[1, 2, 2], [2, 1, 2], [2, 2, 1]}
listOf(1, 2, 2).permutationsNumber() // 3
```

More examples [here](https://github.com/MarcinMoskala/KotlinDiscreteMathToolkit/blob/master/src/com/marcinmoskala/math/tests/com/marcinmoskala/math/tests/PermutationTest.kt)

# Combinations

```kotlin
val subsetSize = 3
setOf(1, 2, 3, 4).combinations(subsetSize) // { {1, 2, 3}, {1, 2, 4}, {1, 4, 3}, {4, 2, 3} }
setOf(1, 2, 3, 4).combinationNumber(subsetSize) // 4

setOf(1, 2, 3, 4).combinationsWithRepetitions(2) // [{1=2}, {1=1, 2=1}, {1=1, 3=1}, {1=1, 4=1}, {2=2}, {2=1, 3=1}, {2=1, 4=1}, {3=2}, {3=1, 4=1}, {4=2}]
setOf(1, 2, 3, 4).combinationsWithRepetitionsNumber(2) // 10
```

More examples [here](https://github.com/MarcinMoskala/KotlinDiscreteMathToolkit/blob/master/src/com/marcinmoskala/math/tests/com/marcinmoskala/math/tests/CombinationTest.kt) and [here](https://github.com/MarcinMoskala/KotlinDiscreteMathToolkit/blob/master/src/com/marcinmoskala/math/tests/com/marcinmoskala/math/tests/CombinationWithRepetitionTest.kt)

# Powerset
Powerset of any set S is the set of all subsets of S, including the empty set and S itself.

```kotlin
setOf(1, 2, 3).powerset() // { {}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3} }
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
3.factorial() // 6L
10.factorial() // 3628800L
20.factorial() // 2432902008176640000L
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
(1..n).toSet().splitsNumber(1) // 1
(1..n).toSet().splitsNumber(n) // 1
setOf(1, 2, 3).splitsNumber(2) // 3
setOf(1, 2, 3, 4).splitsNumber(2) // 7
setOf(1, 2, 3, 4, 5).splitsNumber(3) // 25
setOf(1, 2, 3, 4, 5, 6, 7).splitsNumber(4) // 350
setOf(1, 2, 3).splits(2) // { { {1, 2}, {3} },{ {1, 3}, {2} },{ {3, 2}, {1} } }
```

More examples [here](https://github.com/MarcinMoskala/KotlinDiscreteMathToolkit/blob/master/src/com/marcinmoskala/math/tests/com/marcinmoskala/math/tests/SetSplitTest.kt)

```kotlin
n.splitsNumber(1) // 1
n.splitsNumber(n) // 1
7.splitsNumber(4) // 3
11.splitsNumber(4) // 11
9.splitsNumber(5) // 5
13.splitsNumber(8) // 7
```

More examples [here](https://github.com/MarcinMoskala/KotlinDiscreteMathToolkit/blob/master/src/com/marcinmoskala/math/tests/com/marcinmoskala/math/tests/NumberSplitTest.kt)

# Install

Gradle:
```groovy
compile "com.marcinmoskala:DiscreteMathToolkit:1.0-Final"
```

Maven:
```
<dependency>
  <groupId>com.marcinmoskala</groupId>
  <artifactId>DiscreteMathToolkit</artifactId>
  <version>1.0-Final</version>
</dependency>
```

Jar to download tohether with sources and javadoc can be found on [Maven Central](http://search.maven.org/#search%7Cga%7C1%7Cmarcinmoskala).

License
-------

    Copyright 2017 Marcin Moskała

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
