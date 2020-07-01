# DiscreteMathToolkit
Set of extensions for Kotlin that provides Discrete Math functionalities as an Kotlin extension functions.

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.marcinmoskala/DiscreteMathToolkit/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.marcinmoskala/DiscreteMathToolkit)
[![Build Status](https://travis-ci.org/MarcinMoskala/KotlinDiscreteMathToolkit.svg?branch=master)](https://travis-ci.org/MarcinMoskala/KotlinDiscreteMathToolkit)
[![codecov](https://codecov.io/gh/MarcinMoskala/KotlinDiscreteMathToolkit/branch/master/graph/badge.svg)](https://codecov.io/gh/MarcinMoskala/KotlinDiscreteMathToolkit)
[![codebeat badge](https://codebeat.co/badges/70bb9b0e-a47e-477a-933d-adc7220ae926)](https://codebeat.co/projects/github-com-marcinmoskala-kotlindiscretemathtoolkit-master)
[![Analytics](https://ga-beacon.appspot.com/UA-92159206-7/main-page?pixel)](https://github.com/MarcinMoskala/KotlinDiscreteMathToolkit)

To stay current with news about library [![Twitter URL](https://img.shields.io/twitter/url/https/twitter.com/fold_left.svg?style=social&label=Follow%20%40marcinmoskala)](https://twitter.com/marcinmoskala?ref_src=twsrc%5Etfw)

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
setOf(1, 2, 3, 4).combinations(3) // { {1, 2, 3}, {1, 2, 4}, {1, 4, 3}, {4, 2, 3} }
setOf(1, 2, 3, 4).combinationNumber(3) // 4

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
listOf(1, 2) * listOf("A", "B") // returns List<Pair<Int, String>>
// [(1, "A"), (1, "B"), (2, "A"), (2, "B")] 
listOf('a', 'b') * listOf(1, 2) * listOf("A", "B") // returns List<Triple<Char, Int, String>>
// [
//    ('a', 1, "A"), ('a', 1, "B"), 
//    ('a', 2, "A"), ('a', 2, "B"), 
//    ('b', 1, "A"), ('b', 1, "B"), 
//    ('b', b, "A"), ('b', 2, "B")
// ] 
```

More examples [here](https://github.com/MarcinMoskala/KotlinDiscreteMathToolkit/blob/master/src/test/java/com/marcinmoskala/math/tests/IterableMultipliationTest.kt).

# Cartesian product of lists

Similar to iterable multiplication but produces sequence of lists:

```kotlin
listOf('A', 'B', 'C', D).cartesianProduct(listOf('x', 'y')) // returns List<List<Char>>
// [
//     ['A', 'x'],
//     ['A', 'y'],
//     ['B', 'x'],
//     ['B', 'y'],
//     ['C', 'x'],
//     ['C', 'y'],
//     ['D', 'x'],
//     ['D', 'y']
// ]
listOf(0, 1).cartesianProduct(repeat = 2) // returns List<List<Int>>
// [
//     [0, 0],
//     [0, 1],
//     [1, 0],
//     [1, 1]
// ]
listOf(1, 2).cartesianProduct(listOf("ABC")) // returns List<List<Any>>
// [
//     [1, "ABC"],
//     [2, "ABC"]
// ]
```

More examples [here](https://github.com/MarcinMoskala/KotlinDiscreteMathToolkit/blob/master/src/test/java/com/marcinmoskala/math/tests/CartesianProductTest.kt).

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
compile "com.marcinmoskala:DiscreteMathToolkit:1.0.3"
```

Maven:
```
<dependency>
  <groupId>com.marcinmoskala</groupId>
  <artifactId>DiscreteMathToolkit</artifactId>
  <version>1.0.3</version>
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
