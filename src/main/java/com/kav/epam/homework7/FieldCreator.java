package com.kav.epam.homework7;

/**
 * Field creator for BattleShip
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class FieldCreator {

    /**
     * Method which create a field for game
     *
     * @return field
     */
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

    /**
     * Method which fill cell into field
     *
     * @param field
     */
    private void fieldFill(String[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = "  ";
            }
        }
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (j == 0) {
                    field[i][j] = String.valueOf((char) (i + 65));
                } else {
                    field[i][j] = "[ ]";
                }
            }
        }
    }

    /**
     * Method which print fiedl
     *
     * @param field
     */
    public static void printField(String[][] field) {
        System.out.print("  1  2  3  4  5  6  7  8  9  10");
        System.out.print("                      ");
        System.out.println("  1  2  3  4  5  6  7  8  9  10");
        for (String[] strings : field) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }

    /**
     * Method which set ship on the field
     *
     * @param field
     * @param ship
     */
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
                field[x][i] = "[X]";
            }
        }
    }

    /**
     * Method which check cells for close standing ship
     *
     * @param field
     * @param ship
     */
    private static void nearlyShipCheck(String[][] field, Ship ship) {
        String direction = ship.getDirection();
        int size = ship.size;
        int x = ship.xCoordinateShipHead;
        int y = ship.yCoordinateShipHead;

        if (direction.equalsIgnoreCase("n")) {
            if (size - x > 0) {
                throw new IllegalArgumentException("Wrong direction!");
            }
            for (int i = x + 1; i >= x - ship.size; i--) {
                for (int j = y - 1; j <= y + 1; j++) {
                    stringCheck(field, i, j);
                }
            }
        } else if (direction.equalsIgnoreCase("s")) {
            if (x + size > 10) {
                throw new IllegalArgumentException("Wrong direction!");
            }
            for (int i = x - 1; i <= x + ship.size; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                    stringCheck(field, i, j);
                }
            }
        } else if (direction.equalsIgnoreCase("w")) {
            if (size - y >= 1) {
                throw new IllegalArgumentException("Wrong direction!");
            }
            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y + 1; j >= y - ship.size; j--) {
                    stringCheck(field, i, j);
                }
            }
        } else if (direction.equalsIgnoreCase("e")) {
            if (size + y > 10) {
                throw new IllegalArgumentException("Wrong direction!");
            }
            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + ship.size; j++) {
                    stringCheck(field, i, j);
                }
            }
        }
    }

    /**
     * Method which check cell for ship
     *
     * @param field
     * @param i
     * @param j
     */
    private static void stringCheck(String[][] field, int i, int j) {
        try {
            if (field[i][j].equalsIgnoreCase("[X]")) {
                throw new IllegalArgumentException("Wrong! Another ship too close");
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
    }
}
