package com.kav.epam.homework3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FifthTaskArrayTest {
    FifthTaskArray fifthTaskArray;
    char[][] a = new char[5][5];

    @Before
    public void init() {
        fifthTaskArray = new FifthTaskArray();
        a[0] = new char[]{'A', 'B', 'C', 'D', 'E'};
        a[1] = new char[]{'F', 'G', 'H', 'I', 'J'};
        a[2] = new char[]{'K', 'L', 'M', 'N', 'O'};
        a[3] = new char[]{'P', 'Q', 'R', 'S', 'T'};
        a[4] = new char[]{'U', 'V', 'W', 'X', 'Y'};
    }

    @Test
    public void testGetWordFromUnevenElementsColumn() {
        assertEquals("FPGQHRISJT", fifthTaskArray.getWordFromUnevenElementsColumn(a));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetWordFromUnevenElementsColumnException1() {
        fifthTaskArray.getWordFromUnevenElementsColumn(new char[0][5]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetWordFromUnevenElementsColumnException2() {
        fifthTaskArray.getWordFromUnevenElementsColumn(new char[5][0]);
    }

}
