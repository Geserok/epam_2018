package com.kav.epam.homework7;

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

    public String[][] createComputerField() {
        String[][] computerField = new String[11][11];
        fieldFill(computerField);
        return computerField;
    }

    private void fieldFill(String[][] computerField) {
        for (int i = 0; i < computerField.length; i++) {
            for (int j = 0; j < computerField[i].length; j++) {
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
        int x = ship.xCoordinateShipHead;
        int y = ship.yCoordinateShipHead;
        String direction = ship.getDirection();
        if (direction.equalsIgnoreCase("n")) {
            for (int i = x; i > x - ship.size; i--) {
                field[i][y] = "[X]";
            }
        } else if (direction.equalsIgnoreCase("s")) {
            for (int i = x; i < x + ship.size; i++) {
                field[i][y] = "[X]";
            }
        } else if (direction.equalsIgnoreCase("w")) {
            for (int i = y; i > y - ship.size; i--) {
                field[x][i] = "[X]";
            }
        } else if (direction.equalsIgnoreCase("e")) {
            for (int i = y; i < y + ship.size; i++) {
                field[x][y] = "[X]";
            }
        }

    }

    private static void nearlyShipCheck(String[][] field, Ship ship) {
        String direction = ship.getDirection();
        int x = ship.xCoordinateShipHead;
        int y = ship.yCoordinateShipHead;

        if (direction.equalsIgnoreCase("n")) {
            for (int i = x + 1; i >= x - ship.size; i--) {
                for (int j = y - 1; j <= y + 1; j++) {
                    stringCheck(field, i, j);
                }
            }
        } else if (direction.equalsIgnoreCase("s")) {
            for (int i = x - 1; i <= x + ship.size; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                    stringCheck(field, i, j);
                }
            }
        } else if (direction.equalsIgnoreCase("w")) {
            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y + 1; j >= y - ship.size; j--) {
                    stringCheck(field, i, j);
                }
            }
        } else if (direction.equalsIgnoreCase("e")) {
            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + ship.size; j++) {
                    stringCheck(field, i, j);
                }
            }
        }
    }


    private static void markCoordinate(String[][] field, Ship ship, int i, int j) {
        try {
            if (field[i + ship.xCoordinateShipHead][j].equals("[ ]") ||
                    field[i + ship.xCoordinateShipHead][j].equals("[*]") ||
                    field[i + ship.xCoordinateShipHead][j].equals("[0]")) {
                field[i][j] = "[*]";
            }
        } catch (IndexOutOfBoundsException e) {
            return;
        }
    }

    private static void stringCheck(String[][] field, int i, int j){
        try{
            if (field[i][j].equalsIgnoreCase("[X]")) {
                throw new IllegalArgumentException("Wrong! Another ship too close");
            }
        } catch (ArrayIndexOutOfBoundsException e){

        }
    }

}
