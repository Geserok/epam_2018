package com.kav.epam.homework7.battleShips;

/**
 * ShipFactory Service
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class ShipFactory {
    private Ship ship = null;

    /**
     * Method which create a ship
     *
     * @param size                quantity deck of the ship
     * @param xCoordinateShipHead ordinate of ship head
     * @param yCoordinateShipHead abscissa of ship head
     * @param direction           direction of ship
     * @return
     */
    public Ship createShip(int size, int xCoordinateShipHead, int yCoordinateShipHead, String direction) {

        coordinatesCheck(size, xCoordinateShipHead, yCoordinateShipHead, direction);

        if (size == 1) {
            ship = new SingleDeckShip(xCoordinateShipHead, yCoordinateShipHead, direction);
        } else if (size == 2) {
            ship = new DoubleDeckShip(xCoordinateShipHead, yCoordinateShipHead, direction);
        } else if (size == 3) {
            ship = new ThreeDeckShip(xCoordinateShipHead, yCoordinateShipHead, direction);
        } else if (size == 4) {
            ship = new FourDeckShip(xCoordinateShipHead, yCoordinateShipHead, direction);
        } else {
            throw new IllegalArgumentException("Wrong size of the ship!");
        }
        return ship;
    }

    /**
     * Method which check coordinates of the ship
     *
     * @param size                quantity deck of the ship
     * @param xCoordinateShipHead ordinate of ship head
     * @param yCoordinateShipHead abscissa of ship head
     * @param direction           direction of ship
     */
    private static void coordinatesCheck(int size, int xCoordinateShipHead, int yCoordinateShipHead, String direction) {
        coordinateCheck(xCoordinateShipHead);
        coordinateCheck(yCoordinateShipHead);
        if (direction.equalsIgnoreCase("n")) {
            for (int i = 0; i < size; i++) {
                coordinateCheck(xCoordinateShipHead - i);
            }
        } else if (direction.equalsIgnoreCase("s")) {
            for (int i = 0; i < size; i++) {
                coordinateCheck(xCoordinateShipHead + i);
            }
        } else if (direction.equalsIgnoreCase("w")) {
            for (int i = 0; i < size; i++) {
                coordinateCheck(yCoordinateShipHead - i);
            }
        } else if (direction.equalsIgnoreCase("e")) {
            for (int i = 0; i < size; i++) {
                coordinateCheck(yCoordinateShipHead + i);
            }
        }
    }

    /**
     * Method which check correctness of input coordinates
     *
     * @param coordinate coordinate to check
     */
    private static void coordinateCheck(int coordinate) {
        if (coordinate < 0 || coordinate > 10) {
            throw new IllegalArgumentException("Wrong coordinate!");
        }
    }
}
