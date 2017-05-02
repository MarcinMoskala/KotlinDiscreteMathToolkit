package com.marcinmoskala.math.tests;

import com.marcinmoskala.math.DiscreteMath;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JavaTest {

    private static Set<Integer> smallSet = new HashSet<>();
    private static List<Integer> smallList = new ArrayList<>();

    @BeforeClass
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
        Assert.assertEquals(6, DiscreteMath.permutationsNumber(smallSet));
        Assert.assertEquals(3, DiscreteMath.permutationsNumber(smallList));
    }

    @Test
    public void combinationsTest() {
        Assert.assertEquals(3, DiscreteMath.combinationsNumber(smallSet, 2));
        Assert.assertEquals(6, DiscreteMath.combinationsWithRepetitionsNumber(smallSet, 2));
    }

    @Test
    public void powersetTest() {
        Assert.assertEquals(8, DiscreteMath.getPowersetSize(smallSet));
    }

    @Test
    public void productTest() {
        Assert.assertEquals(0, DiscreteMath.product(smallList));
    }

    @Test
    public void factorialTest() {
        Assert.assertEquals(3628800L, DiscreteMath.factorial(10));
    }

    @Test
    public void splitsOfSetTest() {
        Assert.assertEquals(3, DiscreteMath.splitsNumber(smallSet, 2));
    }

    @Test
    public void splitsOfNumberTest() {
        Assert.assertEquals(3, DiscreteMath.splitsNumber(7, 4));
    }
}
