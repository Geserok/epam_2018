package com.kav.epam.homework7.battleShips;

import com.sun.org.apache.xpath.internal.operations.String;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

public class PlayerTest {
    java.lang.String[][] enemyField;
    String[][] personField;
    ArrayList<Ship> enemyShipPool;
    Computer computer;
    int x;
    int y;

    @Before
    public void init() {
        ShipFactory shipFactory = new ShipFactory();
        computer = new Computer();
        enemyShipPool = new ArrayList<>();
        enemyShipPool.add(shipFactory.createShip(1, 1, 1, "e"));
        x = 1;
        y = 1;
    }

    @Test
    public void autoSetShips() {
        enemyField = computer.autoSetShips();
    }

    @Test
    public void manualSetShips() {
        Player player = new Player();
        java.lang.String[][] strings = player.manualSetShips();
        Assert.assertEquals(new String[11][33], strings);
    }

    @Test
    public void fire() {
        enemyField = computer.autoSetShips();
        for (int i = 0; i < enemyField.length; i++) {
            Arrays.fill(enemyField[i], "[X]");
        }
        boolean fire = Player.fire(enemyField, enemyField, enemyShipPool, x, y);
        Assert.assertEquals(true, fire);

        for (int i = 0; i < enemyField.length; i++) {
            Arrays.fill(enemyField[i], "[ ]");
        }
        boolean fire2 = Player.fire(enemyField, enemyField, enemyShipPool, 2, y);
        Assert.assertEquals(false, fire2);
    }
}