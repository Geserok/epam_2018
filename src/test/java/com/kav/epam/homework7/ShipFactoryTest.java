package com.kav.epam.homework7;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShipFactoryTest {

    ShipFactory shipFactory;

    @Before
    public void init(){
        shipFactory = new ShipFactory();
    }

    @Test
    public void createShip1() {
        Ship ship = shipFactory.createShip(1, 1, 1, "e");
        Assert.assertEquals(1, ship.size);
    }

    @Test
    public void createShip2() {
        Ship ship = shipFactory.createShip(2, 1, 1, "e");
        Assert.assertEquals(2, ship.size);
    }

    @Test
    public void createShip3() {
        Ship ship = shipFactory.createShip(3, 1, 1, "e");
        Assert.assertEquals(3, ship.size);
    }

    @Test
    public void createShip4() {
        Ship ship = shipFactory.createShip(4, 1, 1, "e");
        Assert.assertEquals(4, ship.size);
    }
}