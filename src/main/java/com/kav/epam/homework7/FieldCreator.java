package com.kav.epam.homework7;

import java.util.Arrays;

public class FieldCreator {
    public String[][] create() {
        String[][] result = new String[11][33];
        fieldFill(result);
        for (int i = 0; i < 11; i++) {
            for (int j = 22; j < 33; j++) {
                if (j == 22) {
                    result[i][j] = String.valueOf((char) (i + 65));
                } else {
                    result[i][j] = "[ ]";
                }
            }
        }
        return result;
    }

    public String[][] createComputerField(){
        String[][] computerField = new String[11][11];
        fieldFill(computerField);
        return computerField;
    }

    private void fieldFill(String[][] computerField) {
        for (int i = 0; i < computerField.length; i++){
            for (int j = 0; j < computerField[i].length ; j++) {
                computerField[i][j] = "  ";
            }
        }
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (j == 0) {
                    computerField[i][j] = String.valueOf((char) (i + 65));
                } else {
                    computerField[i][j] = "[ ]";
                }
            }
        }
    }


    public void printField(String[][] arr) {
        System.out.print("  1  2  3  4  5  6  7  8  9  10");
        System.out.print("                      ");
        System.out.println("  1  2  3  4  5  6  7  8  9  10");
        for (String[] strings : arr) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }

    public void setShip(String[][] field, Ship ship) {
        nearlyShipCheck(field, ship);
        if (ship.xCoordinateShipStern == ship.xCoordinateShipHead) {
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
        if (ship.yCoordinateShipStern == ship.yCoordinateShipHead) {
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

    private static void nearlyShipCheck(String[][] field, Ship ship) {
        if (ship.xCoordinateShipHead == ship.xCoordinateShipStern) {
            if (ship.yCoordinateShipHead >= ship.yCoordinateShipStern) {
                for (int i = -1; i < 2; i++) {
                    for (int j = ship.yCoordinateShipStern - 1; j <= ship.yCoordinateShipHead + 1; j++) {
                        try {
                            if (field[i + ship.xCoordinateShipHead][j].equals("[X]")) {
                                throw new IllegalArgumentException("Wrong! Your ships must be farther apart!1");
                            }
                        } catch (IndexOutOfBoundsException e) {
                            continue;
                        }
                    }
                }
            } else if (ship.yCoordinateShipHead < ship.yCoordinateShipStern) {
                for (int i = -1; i < 2; i++) {
                    for (int j = ship.yCoordinateShipHead - 1; j <= ship.yCoordinateShipStern + 1; j++) {
                        try {
                            if (field[i + ship.xCoordinateShipHead][j].equals("[X]")) {
                                throw new IllegalArgumentException("Wrong! Your ships must be farther apart!2");
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            continue;
                        }

                    }
                }
            }
        }
        if (ship.yCoordinateShipHead == ship.yCoordinateShipStern) {
            if (ship.xCoordinateShipHead >= ship.xCoordinateShipStern) {
                for (int i = ship.xCoordinateShipStern - 1; i <= ship.xCoordinateShipHead + 1; i++) {
                    for (int j = -1; j < 2; j++) {
                        try {
                            if (field[i][j + ship.yCoordinateShipStern].equals("[X]")) {
                                throw new IllegalArgumentException("Wrong! Your ships must be farther apart!3");
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            continue;
                        }

                    }
                }
            } else if (ship.xCoordinateShipHead < ship.xCoordinateShipStern) {
                for (int i = ship.xCoordinateShipHead - 1; i <= ship.xCoordinateShipStern + 1; i++) {
                    for (int j = -1; j < 2; j++) {
                        try {
                            if (field[i][j + ship.yCoordinateShipHead].equals("[X]")) {
                                throw new IllegalArgumentException("Wrong! Your ships must be farther apart!4");
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            continue;
                        }
                    }
                }
            }
        }
    }
}
