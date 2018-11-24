package com.kav.epam.homework7.battleShips;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BattleShipServiceTest {
    String[][] enemyField = new String[11][32];
    String[][] personField = new String[11][32];
    Ship ship;
    int x;
    int y;

    @Before
    public void init() {
        ShipFactory shipFactory = new ShipFactory();
        ship = shipFactory.createShip(1, 5, 5, "s");
        String[] string = new String[32];
        Arrays.fill(string, "[ ]");
        Arrays.fill(enemyField, string);
        Arrays.fill(personField, string);
        enemyField[5][5] = "[X]";
        enemyField[9][9] = "[X]";
        personField[5][5] = "[X]";
        personField[9][9] = "[X]";
        x = 5;
        y = 5;
    }

    @Test
    public void testMarkCoordinate() {
        BattleShipService.markCoordinate(enemyField, personField, x, y, ship);
        assertEquals("[*]", personField[x][y]);
        for (int i = x - 1; i < x + 1; i++) {
            for (int j = y - 1; j < y + 1; j++) {
                if (i != x && j != y) {
                    assertEquals("[0]", personField[i][j]);
                }
            }
        }

    }

    @Test
    public void testCoordinateCheck() {
        assertTrue(BattleShipService.coordinateCheck(1, 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCoordinateCheckException() {
        BattleShipService.coordinateCheck(-1, 1);
    }
}