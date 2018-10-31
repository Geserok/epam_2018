package com.kav.epam.homework3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class FirstTaskArrayTest {
    FirstTaskArray firstTaskArrays;
    char[][] charsArray = new char[5][5];

    @Before
    public void init() {
        firstTaskArrays = new FirstTaskArray();
        charsArray[0] = new char[]{'A', 'B', 'C', 'D', 'E'};
        charsArray[1] = new char[]{'F', 'G', 'H', 'I', 'J'};
        charsArray[2] = new char[]{'K', 'L', 'M', 'N', 'O'};
        charsArray[3] = new char[]{'P', 'Q', 'R', 'S', 'T'};
        charsArray[4] = new char[]{'U', 'V', 'W', 'X', 'Y'};
    }

    @Test
    public void testGetStringFromCornersChars() {
        assertEquals("AEUY", firstTaskArrays.getStringFromCornersChars(charsArray));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetStringFromCornersCharsException() {
        firstTaskArrays.getStringFromCornersChars(new char[1][1]);
    }

}
