package com.kav.epam.homework7;

import java.util.Arrays;

public class BattleShipService {
    public static void main(String[] args) {
        ShipFactory shipFactory = new ShipFactory();
        Ship ship = shipFactory.createShip(3, 1, 1, 1, 3);


        FieldCreator fieldCreator = new FieldCreator();
        String[][] strings = fieldCreator.create();
        fieldCreator.setShip(strings, ship);
        Ship ship1 = shipFactory.createShip(4, 4, 5, 1, 5);
        fieldCreator.setShip(strings, ship1);
        fieldCreator.printField(strings);
    }
}
