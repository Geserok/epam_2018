package com.kav.epam.homework7;

public class SingleDeckShip extends Ship {
    public SingleDeckShip(int xCoordinateShipHead, int yCoordinateOfShipHead,
                          int xCoordinateShipStern, int yCoordinateOfShipStern) {
        super(xCoordinateShipHead, yCoordinateOfShipHead, xCoordinateShipStern, yCoordinateOfShipStern);
        this.size = 1;
        this.state = 1;
    }
}
