package com.kav.epam.homework7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BattleShipService {


    public static void main(String[] args) {
        BattleShipService battleShipService = new BattleShipService();
        battleShipService.start();
    }

    public void start() {
        ShipFactory shipFactory = new ShipFactory();

        FieldCreator fieldCreator = new FieldCreator();
        String[][] personField = fieldCreator.create();
        Computer computer = new Computer();

        String[][] computerField = computer.setShips();
        fieldCreator.printField(personField);

        ArrayList<Ship> shipPool = new ArrayList<>();
        ArrayList<Ship> computerShipPool = computer.getComputerShipPool();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
           /* for (int i = 1; i < 5; i++) {
                for (int j = 5 - i; j > 0; j--) {
                    System.out.print("Input a coordinates of " + i + "Deck Ship: ");
                    System.out.print("Input a head coordinates in format (Letter + number) ");
                    int xHead = Character.toLowerCase(reader.readLine().charAt(0)) - 97;
                    int yHead = Integer.parseInt(reader.readLine());
                    System.out.print("Input a stern coordinates in format (Letter + number) ");
                    int xStern = Character.toLowerCase(reader.readLine().charAt(0)) - 97;
                    int yStern = Integer.parseInt(reader.readLine());
                    try {
                        Ship ship = shipFactory.createShip(i, xHead, yHead, xStern, yStern);
                        fieldCreator.setShip(personField, ship);
                        fieldCreator.printField(personField);
                    } catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage());
                        j++;
                    }
                }

            }*/
            Ship ship = shipFactory.createShip(2, Character.toLowerCase('a') - 97, 1, "s");
            Ship ship2 = shipFactory.createShip(1, Character.toLowerCase('e') - 97, 3, "e");
            fieldCreator.setShip(personField, ship);
            fieldCreator.setShip(personField, ship2);
            shipPool.add(ship);
            shipPool.add(ship2);
            fieldCreator.printField(personField);


            while (!isGameOver(personField)) {
                System.out.println("input coordinates to Fire in format (letter + number):");
                int xHead;
                int yHead;
                try {
                    xHead = Character.toLowerCase(reader.readLine().charAt(0)) - 97;
                    yHead = Integer.parseInt(reader.readLine());
                } catch (NumberFormatException e){
                    continue;
                }
                fire(computerField, personField, computerShipPool, xHead, yHead);
                fieldCreator.printField(personField);
            }
            fieldCreator.printField(personField);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean fire(String[][] fieldComputer, String[][] personField, ArrayList<Ship> shipPool, int x, int y) {
        try {
            coordinateCheck(x, y);
        } catch (IllegalArgumentException e) {
            System.out.println("Coordinates is out of range!");
            return true;
        }
        boolean fireFlag = false;
        Ship ship = null;


        for (Ship aShipPool : shipPool) {
            ArrayList<String> coordinates = aShipPool.getCoordinates();
            for (String coordinate : coordinates) {
                String[] split = coordinate.split(" ");
                if (split[0].equals(String.valueOf(x)) && split[1].equals(String.valueOf(y))) {
                    fireFlag = true;
                    ship = aShipPool;
                    break;
                }
            }
        }
        if (fireFlag == true) {
            return markCoordinate(fieldComputer, personField, x , y, ship);
        } else {
            if (fieldComputer[x][y].equals("[0]")) {
                System.out.println("This coordinates were already fired");
                return true;
            } else if (fieldComputer[x][y].equals("[ ]")) {
                System.out.println("Miss");
                personField[x][22 + y] = "[0]";
                fieldComputer[x][y] = "[0]";
                return false;
            }
        }
        return false;
    }

    private boolean markCoordinate(String[][] computerField, String[][] personField, int x, int y, Ship ship) {

        if (computerField[x][y].equals("[X]")) {
            personField[x][22 + y] = "[*]";
            computerField[x][y] = "[*]";
            ship.removeLife();
            if (ship.lives > 0) {
                System.out.println("Hit");
                return true;
            } else {
                if (isGameOver(computerField)) {
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
                                    computerField[i][j] = "[0]";
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
                        computerField[Integer.parseInt(split[0])]
                                [Integer.parseInt(split[1])] = "[*]";
                    } catch (ArrayIndexOutOfBoundsException e) {
                        continue;
                    }
                }
                return true;
            }
        } else if (computerField[x][y].equals("[*]")) {
            System.out.println("This coordinates were already fired");
        }
        return true;
    }

    private void coordinateCheck(int x, int y) {
        if (x < 0 || y < 0 || x > 10 || y > 10) {
            throw new IllegalArgumentException("Bad coordinates!");
        }
    }

    private boolean isGameOver(String[][] field) {
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

    private void remake() {
        String decision;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            decision = reader.readLine();
            if (decision.equalsIgnoreCase("y")) {
                BattleShipService battleShipService = new BattleShipService();
                battleShipService.start();
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
