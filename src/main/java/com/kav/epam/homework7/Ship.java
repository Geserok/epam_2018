package com.kav.epam.homework7;

import java.util.ArrayList;

public abstract class Ship {
    int xCoordinateShipHead;
    int yCoordinateShipHead;
    int xCoordinateShipStern;
    int yCoordinateShipStern;
    int size;
    int state;

    public Ship(int xCoordinateShipHead, int yCoordinateShipHead, int xCoordinateShipStern, int yCoordinateShipStern) {
        this.xCoordinateShipHead = xCoordinateShipHead;
        this.yCoordinateShipHead = yCoordinateShipHead;
        this.xCoordinateShipStern = xCoordinateShipStern;
        this.yCoordinateShipStern = yCoordinateShipStern;
        this.state = this.size;
    }

    public void setState(int state) {
        this.state = this.state - 1;
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

    public int isState() {
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

    public ArrayList<String> getCoordinates(){
        int xHead;
        int xStern;
        int yHead;
        int yStern;
        ArrayList<String> coordinates = new ArrayList<>();
        if (this.xCoordinateShipHead >= this.xCoordinateShipStern){
            xHead = this.xCoordinateShipHead;
            xStern = this.xCoordinateShipStern;
        } else {
            xStern = this.xCoordinateShipHead;
            xHead = this.xCoordinateShipStern;
        }
        if (this.yCoordinateShipHead >= this.yCoordinateShipStern){
            yHead = this.yCoordinateShipHead;
            yStern = this.yCoordinateShipStern;
        } else {
            yStern = this.yCoordinateShipHead;
            yHead = this.yCoordinateShipStern;
        }

        for (int i = xStern; i <= xHead; i++) {
            for (int j = yStern; j <= yHead; j++) {
                coordinates.add(String.valueOf(i) + j);
            }
        }
        return coordinates;
    }
}
