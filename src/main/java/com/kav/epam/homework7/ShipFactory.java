package com.kav.epam.homework7;

public class ShipFactory {
    Ship ship = null;

    public Ship createShip(int size, int xCoordinateShipHead, int yCoordinateShipHead,
                           int xCoordinateShipStern, int yCoordinateShipStern) {
        coordinateCheck(xCoordinateShipHead);
        coordinateCheck(yCoordinateShipHead);
        coordinateCheck(xCoordinateShipStern);
        coordinateCheck(yCoordinateShipStern);

        if (size == 1) {
            ship = new SingleDeckShip(xCoordinateShipHead, yCoordinateShipHead,
                    xCoordinateShipStern, yCoordinateShipStern);
        } else if (size == 2) {
            ship = new DoubleDeckShip(xCoordinateShipHead, yCoordinateShipHead,
                    xCoordinateShipStern, yCoordinateShipStern);
        } else if (size == 3) {
            ship = new ThreeDeckShip(xCoordinateShipHead, yCoordinateShipHead,
                    xCoordinateShipStern, yCoordinateShipStern);
        } else if (size == 4) {
            ship = new FourDeckShip(xCoordinateShipHead, yCoordinateShipHead,
                    xCoordinateShipStern, yCoordinateShipStern);
        } else {
            throw new IllegalArgumentException("Wrong size of the ship!");
        }
        return ship;
    }

    public void coordinateCheck(int coordinate) {
        if (coordinate < 0 || coordinate > 9) {
            throw new IllegalArgumentException("Wrong coordinate!");
        }
    }
}
