package com.kav.epam.homework7;

public class DoubleDeckShip extends Ship {
    public DoubleDeckShip(int xCoordinateShipHead, int yCoordinateOfShipHead, String direction) {
        super(xCoordinateShipHead, yCoordinateOfShipHead, direction);
        this.size = 2;
        this.lives = 2;
    }
}
