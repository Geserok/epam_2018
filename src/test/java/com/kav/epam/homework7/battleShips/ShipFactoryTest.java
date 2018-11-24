package com.kav.epam.homework7.battleShips;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShipFactoryTest {

    ShipFactory shipFactory;

    @Before
    public void init() {
        shipFactory = new ShipFactory();
    }

    @Test
    public void testCreateShip() {
        Ship ship = shipFactory.createShip(1, 1, 1, "e");
        assertEquals(1, ship.size);
        ship = shipFactory.createShip(2, 1, 1, "e");
        assertEquals(2, ship.size);
        ship = shipFactory.createShip(3, 1, 1, "e");
        assertEquals(3, ship.size);
        ship = shipFactory.createShip(4, 1, 1, "e");
        assertEquals(4, ship.size);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateShipException1() {
        Ship ship = shipFactory.createShip(6, 1, 1, "e");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateShipException2() {
        Ship ship = shipFactory.createShip(1, -1, 1, "e");
    }

}