# DiscreteMathToolkit
Set of extensions for Kotlin that provides Discrete Math functionalities as an Kotlin extension functions.

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.marcinmoskala/DiscreteMathToolkit/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.marcinmoskala/DiscreteMathToolkit)
[![Build Status](https://travis-ci.org/MarcinMoskala/KotlinDiscreteMathToolkit.svg?branch=master)](https://travis-ci.org/MarcinMoskala/KotlinDiscreteMathToolkit)
[![codecov](https://codecov.io/gh/MarcinMoskala/KotlinDiscreteMathToolkit/branch/master/graph/badge.svg)](https://codecov.io/gh/MarcinMoskala/KotlinDiscreteMathToolkit)

# Permutations

```kotlin
setOf(1, 2, 3).permutations() // {[1, 2, 3], [2, 1, 3], [3, 2, 1], [1, 3, 2], [2, 3, 1], [3, 1, 2]}
setOf(1, 2, 3).permutationsNumber() // 6
listOf(1, 2, 2).permutations() // {[1, 2, 2], [2, 1, 2], [2, 2, 1]}
listOf(1, 2, 2).permutationsNumber() // 3
```

More examples [here](https://github.com/MarcinMoskala/KotlinDiscreteMathToolkit/blob/master/src/test/java/com/marcinmoskala/math/tests/PermutationTest.kt)

# Combinations

```kotlin
val subsetSize = 3
setOf(1, 2, 3, 4).combinations(subsetSize) // { {1, 2, 3}, {1, 2, 4}, {1, 4, 3}, {4, 2, 3} }
setOf(1, 2, 3, 4).combinationNumber(subsetSize) // 4

setOf(1, 2, 3, 4).combinationsWithRepetitions(2) // [{1=2}, {1=1, 2=1}, {1=1, 3=1}, {1=1, 4=1}, {2=2}, {2=1, 3=1}, {2=1, 4=1}, {3=2}, {3=1, 4=1}, {4=2}]
setOf(1, 2, 3, 4).combinationsWithRepetitionsNumber(2) // 10
```

More examples [here](https://github.com/MarcinMoskala/KotlinDiscreteMathToolkit/blob/master/src/test/java/com/marcinmoskala/math/tests/CombinationTest.kt) and [here](https://github.com/MarcinMoskala/KotlinDiscreteMathToolkit/blob/master/src/test/java/com/marcinmoskala/math/tests/CombinationWithRepetitionTest.kt)

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

More examples [here](https://github.com/MarcinMoskala/KotlinDiscreteMathToolkit/blob/master/src/test/java/com/marcinmoskala/math/tests/ProductTest.kt).

# Factorial
Factorian of n (n!) is a product of all positive integers less than or equal to n. 

```kotlin
3.factorial() // 6L
10.factorial() // 3628800L
20.factorial() // 2432902008176640000L
```
More examples [here](https://github.com/MarcinMoskala/KotlinDiscreteMathToolkit/blob/master/src/test/java/com/marcinmoskala/math/tests/FactorialTest.kt).

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
More examples [here](https://github.com/MarcinMoskala/KotlinDiscreteMathToolkit/blob/master/src/test/java/com/marcinmoskala/math/tests/NumbersDivisibleTest.kt).

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

More examples [here](https://github.com/MarcinMoskala/KotlinDiscreteMathToolkit/blob/master/src/test/java/com/marcinmoskala/math/tests/SetSplitTest.kt)

```kotlin
n.splitsNumber(1) // 1
n.splitsNumber(n) // 1
7.splitsNumber(4) // 3
11.splitsNumber(4) // 11
9.splitsNumber(5) // 5
13.splitsNumber(8) // 7
```

More examples [here](https://github.com/MarcinMoskala/KotlinDiscreteMathToolkit/blob/master/src/test/java/com/marcinmoskala/math/tests/NumberSplitTest.kt)

# Iterable multiplication

Multiplication of iterables returns iterable with pairs of each possible connections of elements from first and iterable:

```kotlin
listOf(1, 2) * listOf("A", "B") // [Pair(1, "A"), Pair(1, "B"), Pair(2, "A"), Pair(2, "B")] 
listOf('a', 'b') * listOf(1, 2) * listOf("A", "B") 
// [
//    Triple('a', 1, "A"), Triple('a', 1, "B"), 
//    Triple('a', 2, "A"), Triple('a', 2, "B"), 
//    Triple('b', 1, "A"), Triple('b', 1, "B"), 
//    Triple('b', b, "A"), Triple('b', 2, "B")
// ] 
```

More examples [here](https://github.com/MarcinMoskala/KotlinDiscreteMathToolkit/blob/master/src/test/java/com/marcinmoskala/math/tests/IterableMultipliationTest.kt).

# Java support

Library is fully supporting usage from Java. All functions can be used as static function of DiscreteMath. For example:

```java
DiscreteMath.permutationsNumber(set)
DiscreteMath.permutationsNumber(list)
DiscreteMath.factorial(10) // 3628800L
```

Returned list and sets are Java standard lists and sets. More examples of Java usage [here](https://github.com/MarcinMoskala/KotlinDiscreteMathToolkit/blob/master/src/test/java/com/marcinmoskala/math/tests/JavaTest.java).

# Install

Gradle:
```groovy
compile "com.marcinmoskala:DiscreteMathToolkit:1.0.2"
```

Maven:
```
<dependency>
  <groupId>com.marcinmoskala</groupId>
  <artifactId>DiscreteMathToolkit</artifactId>
  <version>1.0.2</version>
</dependency>
```

Jar to download together with sources and javadoc can be found on [Maven Central](http://search.maven.org/#search%7Cga%7C1%7Cmarcinmoskala).

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
