package com.kav.epam.homework7;

public class FourDeckShip extends Ship {
    public FourDeckShip(int xCoordinateShipHead, int yCoordinateOfShipHead,
                        int xCoordinateShipStern, int yCoordinateOfShipStern) {
        super(xCoordinateShipHead, yCoordinateOfShipHead, xCoordinateShipStern, yCoordinateOfShipStern);
        this.size = 4;
        this.state = 4;
    }
}
