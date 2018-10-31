package com.kav.epam.homework3;

import org.junit.Before;
import org.junit.Test;

import static com.kav.epam.homework3.ThirdTaskArray.isEven;
import static org.junit.Assert.*;

public class ThirdTaskArrayTest {
    ThirdTaskArray thirdTaskArray;
    char[][] charsArray = new char[5][5];

    @Before
    public void init() {
        thirdTaskArray = new ThirdTaskArray();
        charsArray[0] = new char[]{'A', 'B', 'C', 'D', 'E'};
        charsArray[1] = new char[]{'F', 'G', 'H', 'I', 'J'};
        charsArray[2] = new char[]{'K', 'L', 'M', 'N', 'O'};
        charsArray[3] = new char[]{'P', 'Q', 'R', 'S', 'T'};
        charsArray[4] = new char[]{'U', 'V', 'W', 'X', 'Y'};
    }

    @Test
    public void testGetWordFromArrayInRaws() {
        assertEquals("ACEGIKMOQSUWY", thirdTaskArray.getWordFromArrayInRows(charsArray));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetWordFromArrayInRowsException() {
        thirdTaskArray.getWordFromArrayInRows(new char[5][1]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetWordFromArrayInRowsException2() {
        thirdTaskArray.getWordFromArrayInRows(new char[1][5]);
    }

    @Test
    public void testGetWordFromArrayInColumns() {
        assertEquals("AKUGQCMWISEOY", thirdTaskArray.getWordFromArrayInColumns(charsArray));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetWordFromArrayInColumnsException() {
        thirdTaskArray.getWordFromArrayInColumns(new char[5][1]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetWordFromArrayInColumnsException2() {
        thirdTaskArray.getWordFromArrayInColumns(new char[1][5]);
    }

    @Test
    public void testIsEven() {
        assertTrue(isEven(2));
    }

    @Test
    public void testIsEven2() {
        assertFalse(isEven(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsEvenException() {
        isEven(-1);
    }
}
