package com.kav.epam.homework7;

public abstract class Ship {
    int xCoordinateShipHead;
    int yCoordinateShipHead;
    int xCoordinateShipStern;
    int yCoordinateShipStern;
    int size;
    boolean state;

    public Ship(int xCoordinateShipHead, int yCoordinateShipHead, int xCoordinateShipStern, int yCoordinateShipStern) {
        this.xCoordinateShipHead = xCoordinateShipHead;
        this.yCoordinateShipHead = yCoordinateShipHead;
        this.xCoordinateShipStern = xCoordinateShipStern;
        this.yCoordinateShipStern = yCoordinateShipStern;
        this.state = true;
    }

    public void setState(boolean state) {
        this.state = state;
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

    public void setxCoordinateShipStern(int xCoordinateShipStern) {
        this.xCoordinateShipStern = xCoordinateShipStern;
    }

    public void setyCoordinateShipStern(int yCoordinateShipStern) {
        this.yCoordinateShipStern = yCoordinateShipStern;
    }

    public boolean isState() {
        return state;
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

    public int getxCoordinateShipStern() {
        return xCoordinateShipStern;
    }

    public int getyCoordinateShipStern() {
        return yCoordinateShipStern;
    }
}
