package com.kav.epam.homework7;

public class ThreeDeckShip extends Ship {
    public ThreeDeckShip(int xCoordinateShipHead, int yCoordinateOfShipHead,
                         int xCoordinateShipStern, int yCoordinateOfShipStern) {
        super(xCoordinateShipHead, yCoordinateOfShipHead, xCoordinateShipStern, yCoordinateOfShipStern);
        this.size = 3;
    }
}
