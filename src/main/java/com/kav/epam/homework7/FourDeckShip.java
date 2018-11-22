package com.kav.epam.homework7;

/**
 * FourDeckShip
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class FourDeckShip extends Ship {
    public FourDeckShip(int xCoordinateShipHead, int yCoordinateOfShipHead, String direction) {
        super(xCoordinateShipHead, yCoordinateOfShipHead, direction);
        this.size = 4;
        this.lives = 4;
    }
}
