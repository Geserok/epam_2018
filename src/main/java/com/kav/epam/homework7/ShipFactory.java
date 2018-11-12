package com.kav.epam.homework7;

public class ShipFactory {
    Ship ship = null;

    public Ship createShip(int size, int xCoordinateShipHead, int yCoordinateShipHead,
                           int xCoordinateShipStern, int yCoordinateShipStern) {
        switch (size) {
            case 1:
                ship = new SingleDeckShip(xCoordinateShipHead, yCoordinateShipHead,
                        xCoordinateShipStern, yCoordinateShipStern);
                break;
            case 2:
                ship = new DoubleDeckShip(xCoordinateShipHead, yCoordinateShipHead,
                        xCoordinateShipStern, yCoordinateShipStern);
                break;
            case 3:
                ship = new ThreeDeckShip(xCoordinateShipHead, yCoordinateShipHead,
                        xCoordinateShipStern, yCoordinateShipStern);
                break;
            case 4:
                ship = new FourDeckShip(xCoordinateShipHead, yCoordinateShipHead,
                        xCoordinateShipStern, yCoordinateShipStern);
                break;
        }
        return ship;
    }
}
