package com.kav.epam.homework7.battleShips;

import java.util.ArrayList;

/**
 * Ship
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public abstract class Ship {
    int xCoordinateShipHead;
    int yCoordinateShipHead;
    String direction;
    int size;
    int lives;

    public Ship(int xCoordinateShipHead, int yCoordinateShipHead, String direction) {
        this.xCoordinateShipHead = xCoordinateShipHead;
        this.yCoordinateShipHead = yCoordinateShipHead;
        this.direction = direction;
        this.lives = this.size;
    }

    /**
     * Method which remove one life of Ship
     */
    public void removeLife() {
        this.lives = this.lives - 1;
    }

    public String getDirection() {
        return direction;
    }

    /**
     * Method which return list of coordinates of Ship
     * @return
     */
    public ArrayList<String> getCoordinates(){
        ArrayList<String> coordinates = new ArrayList<>();
        coordinates.add(String.valueOf(xCoordinateShipHead) + " " + yCoordinateShipHead);

        if (direction.equalsIgnoreCase("n")) {
            for (int i = 0; i < size; i++) {
                coordinates.add(String.valueOf(xCoordinateShipHead - i) + " " + yCoordinateShipHead);
            }
        } else if (direction.equalsIgnoreCase("s")) {
            for (int i = 0; i < size; i++) {
                coordinates.add(String.valueOf(xCoordinateShipHead + i) + " " + yCoordinateShipHead);
            }
        } else if (direction.equalsIgnoreCase("w")) {
            for (int i = 0; i < size; i++) {
                coordinates.add(String.valueOf(xCoordinateShipHead) + " " + String.valueOf(yCoordinateShipHead - i));
            }
        } else if (direction.equalsIgnoreCase("e")) {
            for (int i = 0; i < size; i++) {
                coordinates.add(String.valueOf(xCoordinateShipHead) + " " + String.valueOf(yCoordinateShipHead + i));
            }
        }
        return coordinates;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "xCoordinateShipHead=" + xCoordinateShipHead +
                ", yCoordinateShipHead=" + yCoordinateShipHead +
                ", direction='" + direction + '\'' +
                ", size=" + size +
                '}';
    }
}
