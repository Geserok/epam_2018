package com.kav.epam.homework4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RecursionTaskThirdTest {
    RecursionTaskThird recursionTaskThird;

    @Before
    public void init() {
        recursionTaskThird = new RecursionTaskThird();
    }

    @Test
    public void testSumOfCountNumber() {
        assertEquals(6, recursionTaskThird.sumOfCountNumber(123));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSumOfCountNumberException() {
        assertEquals(6, recursionTaskThird.sumOfCountNumber(-123));
    }

    @Test
    public void testQuantityOfCount() {
        assertEquals(3, recursionTaskThird.quantityOfCount(123));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testQuantityOfCountException() {
        assertEquals(3, recursionTaskThird.quantityOfCount(-123));
    }
}
