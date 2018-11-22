package com.kav.epam.homework7.battleShips;

/**
 * ThreeDeckShip
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class ThreeDeckShip extends Ship {
    public ThreeDeckShip(int xCoordinateShipHead, int yCoordinateOfShipHead, String direction) {
        super(xCoordinateShipHead, yCoordinateOfShipHead, direction);
        this.size = 3;
        this.lives = 3;
    }
}
