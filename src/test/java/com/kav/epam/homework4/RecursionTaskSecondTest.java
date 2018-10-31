package com.kav.epam.homework4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RecursionTaskSecondTest {
    RecursionTaskSecond recursionTaskSecond;

    @Before
    public void init() {
        recursionTaskSecond = new RecursionTaskSecond();
    }

    @Test
    public void testGetPoweredNumber1() {
        assertEquals(27.0, recursionTaskSecond.getPoweredNumber(3, 3), 0);
    }

    @Test
    public void testGetPoweredNumber2() {
        assertEquals(0.125, recursionTaskSecond.getPoweredNumber(2, -3), 0.0001);
    }

    @Test
    public void testGetPoweredNumber3() {
        assertEquals(-8, recursionTaskSecond.getPoweredNumber(-2, 3), 0.0001);
    }

    @Test
    public void testGetPoweredNumber4() {
        assertEquals(-0.125, recursionTaskSecond.getPoweredNumber(-2, -3), 0.0001);
    }

    @Test
    public void testGetPoweredNumber5() {
        assertEquals(0, recursionTaskSecond.getPoweredNumber(0, 3), 0.0001);
    }

}
