package com.kav.epam.homework7;

public class FieldCreator {
    public String[][] create() {
        String[][] result = new String[11][11];
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (j == 0) {
                    result[i][j] = String.valueOf((char) (i + 65));
                } else {
                    result[i][j] = "[ ]";
                }
            }
        }
        return result;
    }


    public void printField(String[][] arr) {
        System.out.println("  1  2  3  4  5  6  7  8  9  10");
        for (String[] strings : arr) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }

    public void setShip(String[][] field, Ship ship) {
        if(ship.xCoordinateShipStern == ship.xCoordinateShipHead) {
            if (ship.yCoordinateShipStern >= ship.yCoordinateShipHead) {
                for (int i = ship.yCoordinateShipHead; i <= ship.yCoordinateShipStern; i++) {
                    field[ship.xCoordinateShipStern][i] = "[X]";
                }
            } else {
                for (int i = ship.yCoordinateShipStern; i <= ship.yCoordinateShipHead; i++) {
                    field[ship.xCoordinateShipStern][i] = "[X]";
                }
            }
        }
        if(ship.yCoordinateShipStern == ship.yCoordinateShipHead) {
            if (ship.xCoordinateShipStern >= ship.xCoordinateShipHead) {
                for (int i = ship.xCoordinateShipHead; i <= ship.xCoordinateShipStern; i++) {
                    field[i][ship.yCoordinateShipHead] = "[X]";
                }
            } else {
                for (int i = ship.xCoordinateShipStern; i <= ship.xCoordinateShipHead; i++) {
                    field[i][ship.yCoordinateShipHead] = "[X]";
                }
            }
        }

    }
}
