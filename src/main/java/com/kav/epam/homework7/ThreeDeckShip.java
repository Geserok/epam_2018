package com.kav.epam.homework7;

public class ThreeDeckShip extends Ship {
    public ThreeDeckShip(int xCoordinateShipHead, int yCoordinateOfShipHead, String direction) {
        super(xCoordinateShipHead, yCoordinateOfShipHead, direction);
        this.size = 3;
        this.lives = 3;
    }
}
