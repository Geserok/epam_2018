package com.kav.epam.lesson9;


import org.junit.*;

import static org.junit.Assert.*;

/**
 * @Author Andrey Kudarenko
 * @Since 1.8
 */
public class MathLogicTest {
    static int num;
    MathLogic mathLogic;

    @Before
    public void init() {
        mathLogic = new MathLogic();
    }

    @Test
    public void testIsEven() {
        assertEquals(true, mathLogic.isEven(2));
        assertEquals(false, mathLogic.isEven(3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsEvenException() {
        mathLogic.isEven(-1);
    }

    @Test(timeout = 2)
    public void testIsEvenTimeout() {
        assertTrue(mathLogic.isEven(2));
    }

    @Test
    public void testMulp() {
        assertEquals(4, mathLogic.mult(2, 2));
        assertNotEquals(4, mathLogic.mult(2, 3));
    }


}
