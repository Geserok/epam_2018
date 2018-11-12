package com.kav.epam.homework7;

public abstract class Ship {
    int xCoordinateShipHead;
    int yCoordinateOfShipHead;
    int xCoordinateShipStern;
    int yCoordinateOfShipStern;
    int size;
    boolean state;

    public Ship(int xCoordinateShipHead, int yCoordinateOfShipHead, int xCoordinateShipStern, int yCoordinateOfShipStern) {
        this.xCoordinateShipHead = xCoordinateShipHead;
        this.yCoordinateOfShipHead = yCoordinateOfShipHead;
        this.xCoordinateShipStern = xCoordinateShipStern;
        this.yCoordinateOfShipStern = yCoordinateOfShipStern;
        this.state = true;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void setxCoordinateShipHead(int xCoordinateShipHead) {
        this.xCoordinateShipHead = xCoordinateShipHead;
    }

    public void setyCoordinateOfShipHead(int yCoordinateOfShipHead) {
        this.yCoordinateOfShipHead = yCoordinateOfShipHead;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setxCoordinateShipStern(int xCoordinateShipStern) {
        this.xCoordinateShipStern = xCoordinateShipStern;
    }

    public void setyCoordinateOfShipStern(int yCoordinateOfShipStern) {
        this.yCoordinateOfShipStern = yCoordinateOfShipStern;
    }

    public boolean isState() {
        return state;
    }

    public int getxCoordinateShipHead() {
        return xCoordinateShipHead;
    }

    public int getyCoordinateOfShipHead() {
        return yCoordinateOfShipHead;
    }

    public int getSize() {
        return size;
    }

    public int getxCoordinateShipStern() {
        return xCoordinateShipStern;
    }

    public int getyCoordinateOfShipStern() {
        return yCoordinateOfShipStern;
    }
}
