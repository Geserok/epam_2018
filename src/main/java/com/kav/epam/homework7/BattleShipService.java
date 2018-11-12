package com.kav.epam.homework7;

public class BattleShipService {
    public static void main(String[] args) {
        ShipFactory shipFactory = new ShipFactory();
        Ship ship = new ShipFactory().createShip(1, 1, 1, 1, 1);
        System.out.println(ship.getSize());
    }
}
