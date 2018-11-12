package com.kav.epam.homework7;

public class DoubleDeckShip extends Ship {
    public DoubleDeckShip(int xCoordinateShipHead, int yCoordinateOfShipHead,
                          int xCoordinateShipStern, int yCoordinateOfShipStern) {
        super(xCoordinateShipHead, yCoordinateOfShipHead, xCoordinateShipStern, yCoordinateOfShipStern);
        this.size = 2;
    }
}
