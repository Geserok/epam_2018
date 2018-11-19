package com.kav.epam.homework7;

public class SingleDeckShip extends Ship {
    public SingleDeckShip(int xCoordinateShipHead, int yCoordinateOfShipHead, String direction) {
        super(xCoordinateShipHead, yCoordinateOfShipHead, direction);
        this.size = 1;
        this.lives = 1;
    }
}
