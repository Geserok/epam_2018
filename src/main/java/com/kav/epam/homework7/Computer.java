package com.kav.epam.homework7;

import java.util.ArrayList;
import java.util.Random;

public class Computer {
    ArrayList<Ship> computerShipPool = new ArrayList<>();

    public String[][] setShips() {
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
                    computerShipPool.add(ship);

                } catch (IllegalArgumentException e) {
                    j++;
                }
            }
        }
        fieldCreator.printField(compField);
        return compField;
    }

    public ArrayList<Ship> getComputerShipPool() {
        return computerShipPool;
    }
}
