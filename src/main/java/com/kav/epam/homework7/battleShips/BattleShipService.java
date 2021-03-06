package com.kav.epam.homework7.battleShips;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static com.kav.epam.homework7.battleShips.FieldCreator.printField;

/**
 * BattleShip Service
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class BattleShipService {

    public static void main(String[] args) {
        BattleShipService battleShipService = new BattleShipService();
        battleShipService.startPreparation();
    }

    /**
     * Method which start prepare part
     */
    public void startPreparation() {
        Computer computer = new Computer();
        Person person = new Person();

        String[][] computerField = computer.autoSetShips();
        String[][] personField;

        System.out.println("Do you want to set ships yourself? y or n");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                String s = reader.readLine();
                if (s.equalsIgnoreCase("y")) {
                    personField = person.manualSetShips();
                    printField(personField);
                    break;
                } else if (s.equalsIgnoreCase("n")) {
                    personField = person.autoSetShips();
                    printField(personField);
                    break;
                }
            }
            ArrayList<Ship> computerShipPool = computer.getShipPool();
            ArrayList<Ship> personShipPool = person.getShipPool();
            startBattle(computerField, personField, computerShipPool, personShipPool, reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method which start the battle part
     *
     * @param computerField    field with computer's ships
     * @param personField      field with player's ships
     * @param computerShipPool list of computer's ships
     * @param personShipPool   list of person's ships
     * @param reader           buffered reader
     * @throws IOException
     */
    private void startBattle(String[][] computerField, String[][] personField,
                             ArrayList<Ship> computerShipPool, ArrayList<Ship> personShipPool,
                             BufferedReader reader) {
        boolean turn = true;
        while (!isGameOver(personField) || !isGameOver(computerField)) {
            System.out.println("input coordinates to Fire in format (letter + number):");
            int xHead;
            int yHead;

            while (turn) {
                try {
                    xHead = Character.toLowerCase(reader.readLine().charAt(0)) - 97;
                    yHead = Integer.parseInt(reader.readLine());
                    turn = Person.fire(computerField, personField, computerShipPool, xHead, yHead);
                    printField(personField);
                } catch (NumberFormatException e) {
                    continue;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            while (!turn) {
                turn = !Computer.fire(personField, computerField, personShipPool);
                printField(personField);
            }
        }
        printField(personField);
    }

    /**
     * Method which marks cells in field
     *
     * @param enemyField  enemy field
     * @param personField person's
     * @param x           x coordinate
     * @param y           y coordinate
     * @param ship        ship which coordinates should be marked
     * @return
     */
    public static boolean markCoordinate(String[][] enemyField,
                                         String[][] personField, int x, int y, Ship ship) {
        if (enemyField[x][y].equals("[X]")) {
            personField[x][22 + y] = "[*]";
            enemyField[x][y] = "[*]";
            ship.removeLife();
            if (ship.lives > 0) {
                System.out.println("Hit");
                return true;
            } else {
                if (isGameOver(enemyField)) {
                    System.out.println("Game is over! Do you want to remake? Press y or n");
                    remake();
                }
                System.out.println("Kill");
                ArrayList<String> coordinates = ship.getCoordinates();

                for (String coordinate : coordinates) {
                    String[] split = coordinate.split(" ");
                    for (int i = Integer.parseInt(split[0]) - 1; i < Integer.parseInt(
                            split[0]) + 2; i++) {
                        for (int j = Integer.parseInt(split[1]) - 1;
                             j < Integer.parseInt(split[1]) + 2; j++) {
                            try {
                                if (j > 0 && j <= 10) {
                                    personField[i][j + 22] = "[0]";
                                    enemyField[i][j] = "[0]";
                                }
                            } catch (ArrayIndexOutOfBoundsException e) {
                                continue;
                            }
                        }
                    }
                }
                for (String coordinate : coordinates) {
                    String[] split = coordinate.split(" ");
                    try {
                        personField[Integer.parseInt(split[0])]
                                [22 + Integer.parseInt(split[1])] = "[*]";
                        enemyField[Integer.parseInt(split[0])]
                                [Integer.parseInt(split[1])] = "[*]";
                    } catch (ArrayIndexOutOfBoundsException e) {
                        continue;
                    }
                }
                return true;
            }
        } else if (enemyField[x][y].equals("[*]")) {
            System.out.println("This coordinates were already fired");
        }
        return true;
    }

    /**
     * Method which check correctness of input coordinates
     *
     * @param x coordinate
     * @param y coordinate
     */
    public static boolean coordinateCheck(int x, int y) {
        if (x < 0 || y < 0 || x > 10 || y > 10) {
            throw new IllegalArgumentException("Bad coordinates!");
        }
        return true;
    }

    /**
     * Method which check game over
     *
     * @param field which will be checked
     * @return true if field include alive ships
     */
    private static boolean isGameOver(String[][] field) {
        boolean winFlag = true;
        for (int i = 0; i < field.length - 1; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j].equals("[X]")) {
                    winFlag = false;
                }
            }
        }
        return winFlag;
    }

    /**
     * Method which do remake of game
     */
    private static void remake() {
        String decision;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            decision = reader.readLine();
            if (decision.equalsIgnoreCase("y")) {
                BattleShipService battleShipService = new BattleShipService();
                battleShipService.startPreparation();
            } else if (decision.equalsIgnoreCase("n")) {
                System.exit(1);
            } else {
                System.out.println("Uncorrected insert");
                remake();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
