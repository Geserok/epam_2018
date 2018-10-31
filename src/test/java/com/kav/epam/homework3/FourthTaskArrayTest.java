package com.kav.epam.homework3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class FourthTaskArrayTest {
    FourthTaskArray fourthTaskArray;
    char[][] a = new char[5][5];

    @Before
    public void init() {
        fourthTaskArray = new FourthTaskArray();
        a[0] = new char[]{'A', 'B', 'C', 'D', 'E'};
        a[1] = new char[]{'F', 'G', 'H', 'I', 'J'};
        a[2] = new char[]{'K', 'L', 'M', 'N', 'O'};
        a[3] = new char[]{'P', 'Q', 'R', 'S', 'T'};
        a[4] = new char[]{'U', 'V', 'W', 'X', 'Y'};
    }

    @Test
    public void testGetWordFromEvenElementsRows() {
        assertEquals("ACEFHJKMOPRTUWY", fourthTaskArray.getWordFromEvenElementsRows(a));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetWordFromEvenElementsRowsException1() {
        fourthTaskArray.getWordFromEvenElementsRows(new char[0][5]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetWordFromEvenElementsRowsException2() {
        fourthTaskArray.getWordFromEvenElementsRows(new char[5][0]);
    }
}
