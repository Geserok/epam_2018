package com.kav.epam.homework7.battleShips;

/**
 * SingleDeckShip
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class SingleDeckShip extends Ship {
    public SingleDeckShip(int xCoordinateShipHead, int yCoordinateOfShipHead, String direction) {
        super(xCoordinateShipHead, yCoordinateOfShipHead, direction);
        this.size = 1;
        this.lives = 1;
    }
}
