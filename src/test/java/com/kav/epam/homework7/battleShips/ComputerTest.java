package com.kav.epam.homework7.battleShips;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ComputerTest {
    Computer computer;
    String[] string;
    String[][] enemyField = new String[11][32];
    String[][] personField = new String[11][32];

    @Before
    public void init() {
        string = new String[32];
        Arrays.fill(string, "[ ]");
        Arrays.fill(enemyField, string);
        Arrays.fill(personField, string);
        enemyField[5][5] = "[X]";
        enemyField[9][9] = "[X]";
        personField[5][5] = "[X]";
        personField[9][9] = "[X]";
        computer = new Computer();
    }

    @Test
    public void testAutoSetShips() {
        String[][] strings = computer.autoSetShips();
        Assert.assertTrue(strings.length == 32);
        Arrays.fill(strings[1],string);
        Assert.assertTrue(string.length == 32);
    }

}