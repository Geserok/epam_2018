package com.kav.epam.homework7;

public class ShipFactory {
    private Ship ship = null;

    public Ship createShip(int size, int xCoordinateShipHead, int yCoordinateShipHead,
                           int xCoordinateShipStern, int yCoordinateShipStern) {

        coordinatesCheck(size, xCoordinateShipHead, yCoordinateShipHead,
        xCoordinateShipStern, yCoordinateShipStern);

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

    private static void coordinatesCheck(int size, int xCoordinateShipHead, int yCoordinateShipHead,
                                         int xCoordinateShipStern, int yCoordinateShipStern) {
        coordinateCheck(xCoordinateShipHead);
        coordinateCheck(yCoordinateShipHead);
        coordinateCheck(xCoordinateShipStern);
        coordinateCheck(yCoordinateShipStern);

        if (yCoordinateShipStern == yCoordinateShipHead) {
            if (xCoordinateShipStern == xCoordinateShipHead && size != 1) {
                throw new IllegalArgumentException("Bad coordinates. Size is not true");
            }
            if (Math.abs(xCoordinateShipStern - xCoordinateShipHead) != size - 1) {
                throw new IllegalArgumentException("Bad coordinates. Size is not true");
            }
        }

        if (xCoordinateShipStern == xCoordinateShipHead) {
            if (Math.abs(yCoordinateShipStern - yCoordinateShipHead) != size - 1) {
                throw new IllegalArgumentException("Bad coordinates. Size is not true");
            }
        }

        if (yCoordinateShipStern != yCoordinateShipHead &&
                xCoordinateShipStern != xCoordinateShipHead) {
            throw new IllegalArgumentException("Bad coordinates. Ships must be line");
        }
    }

    private static void coordinateCheck(int coordinate) {
        if (coordinate < 0 || coordinate > 10) {
            throw new IllegalArgumentException("Wrong coordinate! Coordinate must be from 1 to 10");
        }
    }
}
