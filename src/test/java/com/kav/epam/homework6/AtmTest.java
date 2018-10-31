package com.kav.epam.homework6;

import org.junit.Test;

public class AtmTest {
    Atm atm;

    @Test(expected = IllegalArgumentException.class)
    public void testAtmException() {
        atm = new Atm(-1, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAtmException2() {
        atm = new Atm(10, -1);
    }
}
