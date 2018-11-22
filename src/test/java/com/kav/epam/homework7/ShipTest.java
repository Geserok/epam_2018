package com.kav.epam.homework7;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ShipTest {
    Ship ship;
    ShipFactory shipFactory = new ShipFactory();

    @Before
    public void init() {
        ship = shipFactory.createShip(1, 1, 1, "w");
    }

    @Test
    public void removeLife() {
        ship.removeLife();
        Assert.assertEquals(0, ship.lives);
    }

    @Test
    public void getCoordinates() {
        ArrayList<String> coordinates = ship.getCoordinates();
        Assert.assertEquals("1 1", coordinates.get(0));
    }
}