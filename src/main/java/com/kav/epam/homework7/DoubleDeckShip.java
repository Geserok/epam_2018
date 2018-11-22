package com.kav.epam.homework7;

/**
 * DoubleDeckShip
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class DoubleDeckShip extends Ship {
    public DoubleDeckShip(int xCoordinateShipHead, int yCoordinateOfShipHead, String direction) {
        super(xCoordinateShipHead, yCoordinateOfShipHead, direction);
        this.size = 2;
        this.lives = 2;
    }
}
