package com.kav.epam.homework6.atm;

import org.junit.Before;
import org.junit.Test;

public class AtmServiceTest {
    AtmService atmService;

    @Before
    public void init() {
        atmService = new AtmService();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStartException() {
        atmService.start(-1, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStartException2() {
        atmService.start(10, -1);
    }

}
