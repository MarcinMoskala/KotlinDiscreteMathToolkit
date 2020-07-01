package com.marcinmoskala.math.tests;

import com.marcinmoskala.math.DiscreteMath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JavaTest {

    private static Set<Integer> smallSet = new HashSet<>();
    private static List<Integer> smallList = new ArrayList<>();

    @BeforeAll
    static public void setUp() {
        smallSet.add(0);
        smallSet.add(1);
        smallSet.add(2);
        smallList.add(0);
        smallList.add(1);
        smallList.add(1);
    }

    @Test
    public void permutationsTest() {
        Assertions.assertEquals(6, DiscreteMath.permutationsNumber(smallSet));
        Assertions.assertEquals(3, DiscreteMath.permutationsNumber(smallList));
    }

    @Test
    public void combinationsTest() {
        Assertions.assertEquals(3, DiscreteMath.combinationsNumber(smallSet, 2));
        Assertions.assertEquals(6, DiscreteMath.combinationsWithRepetitionsNumber(smallSet, 2));
    }

    @Test
    public void powersetTest() {
        Assertions.assertEquals(8, DiscreteMath.getPowersetSize(smallSet));
    }

    @Test
    public void productTest() {
        Assertions.assertEquals(0, DiscreteMath.product(smallList));
    }

    @Test
    public void factorialTest() {
        Assertions.assertEquals(3628800L, DiscreteMath.factorial(10));
    }

    @Test
    public void splitsOfSetTest() {
        Assertions.assertEquals(3, DiscreteMath.splitsNumber(smallSet, 2));
    }

    @Test
    public void splitsOfNumberTest() {
        Assertions.assertEquals(3, DiscreteMath.splitsNumber(7, 4));
    }

    @Test
    public void iterableMultiplicationTest() {
        Assertions.assertEquals(smallList.size() * smallList.size(), DiscreteMath.times(smallList, smallList).size());
    }
}
