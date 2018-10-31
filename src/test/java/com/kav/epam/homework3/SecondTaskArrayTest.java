package com.kav.epam.homework3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class SecondTaskArrayTest {
    SecondTaskArray secondTaskArray;
    int numberOfRow;
    int[] numbers = new int[3];
    char[][] charsArray = new char[5][5];

    @Before
    public void init() {
        secondTaskArray = new SecondTaskArray();
        charsArray[0] = new char[]{'A', 'B', 'C', 'D', 'E'};
        charsArray[1] = new char[]{'F', 'G', 'H', 'I', 'J'};
        charsArray[2] = new char[]{'K', 'L', 'M', 'N', 'O'};
        charsArray[3] = new char[]{'P', 'Q', 'R', 'S', 'T'};
        charsArray[4] = new char[]{'U', 'V', 'W', 'X', 'Y'};

        numberOfRow = 2;

        numbers[0] = 3;
        numbers[1] = 2;
        numbers[2] = 1;
    }

    @Test
    public void testGetWordFromArray() {
        assertEquals("NML", secondTaskArray.getWordFromArray(numberOfRow, numbers, charsArray));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetWordFromArrayException1() {
        secondTaskArray.getWordFromArray(-1, numbers, charsArray);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetWordFromArrayException2() {
        secondTaskArray.getWordFromArray(1, numbers, new char[1][1]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetWordFromArrayException3() {
        numbers[1] = -2;
        secondTaskArray.getWordFromArray(1, numbers, new char[1][1]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetWordFromArrayException4() {
        numbers[1] = 1;
        secondTaskArray.getWordFromArray(1, numbers, new char[1][1]);
    }
}
