package com.kav.epam.homework7;

import java.util.ArrayList;

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

    public void removeLife() {
        this.lives = this.lives - 1;
    }

    public void setxCoordinateShipHead(int xCoordinateShipHead) {
        this.xCoordinateShipHead = xCoordinateShipHead;
    }

    public void setyCoordinateShipHead(int yCoordinateShipHead) {
        this.yCoordinateShipHead = yCoordinateShipHead;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int isState() {
        return lives;
    }

    public int getxCoordinateShipHead() {
        return xCoordinateShipHead;
    }

    public int getyCoordinateShipHead() {
        return yCoordinateShipHead;
    }

    public int getSize() {
        return size;
    }

    public String getDirection() {
        return direction;
    }

    public ArrayList<String> getCoordinates(){
        ArrayList<String> coordinates = new ArrayList<>();
        coordinates.add(String.valueOf(xCoordinateShipHead) + yCoordinateShipHead);

        if (direction.equalsIgnoreCase("n")) {
            for (int i = 0; i < size; i++) {
                coordinates.add(String.valueOf(xCoordinateShipHead - i) + yCoordinateShipHead);
            }
        } else if (direction.equalsIgnoreCase("s")) {
            for (int i = 0; i < size; i++) {
                coordinates.add(String.valueOf(xCoordinateShipHead + i) + yCoordinateShipHead);
            }
        } else if (direction.equalsIgnoreCase("w")) {
            for (int i = 0; i < size; i++) {
                coordinates.add(String.valueOf(xCoordinateShipHead) + String.valueOf(yCoordinateShipHead - i));
            }
        } else if (direction.equalsIgnoreCase("e")) {
            for (int i = 0; i < size; i++) {
                coordinates.add(String.valueOf(xCoordinateShipHead) + String.valueOf(yCoordinateShipHead + i));
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
