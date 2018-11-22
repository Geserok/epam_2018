package com.kav.epam.homework7.battleShips;

import java.util.ArrayList;
import java.util.Random;

/**
 * Player
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class Player {
    ArrayList<Ship> shipPool = new ArrayList<>();

    /**
     * Method which auto set ships
     *
     * @return
     */
    public String[][] autoSetShips() {

        ShipFactory shipFactory = new ShipFactory();
        FieldCreator fieldCreator = new FieldCreator();
        String[][] compField = fieldCreator.create();
        for (int i = 1; i < 5; i++) {
            for (int j = 5 - i; j > 0; j--) {
                Random random = new Random();
                int xHead = random.nextInt(10);
                int yHead = 1 + random.nextInt(10);
                String direction = null;

                switch (random.nextInt(4)) {
                    case 0:
                        direction = "n";
                        break;
                    case 1:
                        direction = "s";
                        break;
                    case 2:
                        direction = "w";
                        break;
                    case 3:
                        direction = "e";
                        break;
                }

                try {
                    Ship ship = shipFactory.createShip(i, xHead, yHead, direction);
                    fieldCreator.setShip(compField, ship);
                    shipPool.add(ship);

                } catch (IllegalArgumentException e) {
                    j++;
                }
            }
        }
        return compField;
    }

    /**
     * Method which manual set ships
     *
     * @return
     */
    public String[][] manualSetShips() {
        return new String[11][33];
    }

    /**
     * Method which modeling attack
     *
     * @param enemyField
     * @param personField
     * @param enemyShipPool
     * @param x
     * @param y
     * @return
     */
    public static boolean fire(String[][] enemyField, String[][] personField,
                               ArrayList<Ship> enemyShipPool, int x, int y) {
        try {
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
                System.out.println("Miss");
                personField[x][22 + y] = "[0]";
                enemyField[x][y] = "[0]";
                return false;
            }
        }
        return false;
    }

    public ArrayList<Ship> getShipPool() {
        return shipPool;
    }

}
