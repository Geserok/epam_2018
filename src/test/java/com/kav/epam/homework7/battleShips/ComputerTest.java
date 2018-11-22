package com.kav.epam.homework7.battleShips;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ComputerTest {
    Computer computer;
    String[][] enemyField;
    String[][] personField;
    @Before
    public void init() {
        computer = new Computer();
    }

    @Test
    public void autoSetShips() {
        computer.autoSetShips();
    }

    @Test
    public void fire(String[][] enemyField,
                     String[][] personField, ArrayList<Ship> enemyShipPool) {
        enemyField = computer.autoSetShips();
        personField = enemyField;
        enemyShipPool =  computer.getShipPool();
        Computer.fire(enemyField, personField, enemyShipPool);
    }
}