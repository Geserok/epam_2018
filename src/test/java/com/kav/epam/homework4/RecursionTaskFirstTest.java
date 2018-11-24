package com.kav.epam.homework4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RecursionTaskFirstTest {
    RecursionTaskFirst recursionTaskFirst;

    @Before
    public void init() {
        recursionTaskFirst = new RecursionTaskFirst();
    }

    @Test
    public void testGetFactorial() {
        assertEquals(5 * 4 * 3 * 2 * 1, recursionTaskFirst.getFactorial(5));
    }

    @Test
    public void testGetFactorialByZero() {
        assertEquals(1, recursionTaskFirst.getFactorial(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetFactorialException() {
        recursionTaskFirst.getFactorial(-1);
    }
}
