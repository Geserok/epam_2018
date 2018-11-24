package com.kav.epam.homework7.battleShips;

import java.util.ArrayList;
import java.util.Random;

/**
 * Computer
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class Computer extends Player {
    ArrayList<Ship> computerShipPool = new ArrayList<>();

    /**
     * Method which auto set ships
     *
     * @return
     */
    @Override
    public String[][] autoSetShips() {
        Player player = new Player();
        String[][] strings = player.autoSetShips();
        computerShipPool = player.getShipPool();
        return strings;
    }

    public ArrayList<Ship> getShipPool() {
        return computerShipPool;
    }

    /**
     * Method which modeling computer attack
     *
     * @param enemyField    enemy field with ships
     * @param personField   person field with ships
     * @param enemyShipPool list of enemy ships
     * @return true if shoot was accurate
     */
    public static boolean fire(String[][] enemyField,
                               String[][] personField, ArrayList<Ship> enemyShipPool) {
        Random random = new Random();
        int x;
        int y;
        try {
            x = random.nextInt(10);
            y = 1 + random.nextInt(11);
            BattleShipService.coordinateCheck(x, y);
        } catch (IllegalArgumentException e) {
            System.out.println("Coordinates is out of range!");
            return true;
        }
        boolean fireFlag = false;
        Ship ship = null;

        for (Ship aShipPool : enemyShipPool) {
            ArrayList<String> coordinates = aShipPool.getCoordinates();
            for (String coordinate : coordinates) {
                String[] split = coordinate.split(" ");
                if (split[0].equals(String.valueOf(x)) && split[1].equals(String.valueOf(y))) {
                    fireFlag = true;
                    ship = aShipPool;
                    break;
                }
            }
        }
        if (fireFlag == true) {
            return BattleShipService.markCoordinate(enemyField, personField, x, y, ship);
        } else {
            if (enemyField[x][y].equals("[0]")) {
                System.out.println("This coordinates were already fired");
                return true;
            } else if (enemyField[x][y].equals("[ ]")) {
                System.out.println("Computer: Miss");
                enemyField[x][y] = "[0]";
                return false;
            }
        }
        return false;
    }
}
