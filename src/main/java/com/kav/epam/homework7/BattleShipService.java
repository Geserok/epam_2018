package com.kav.epam.homework7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BattleShipService {


    public static void main(String[] args) {
        BattleShipService battleShipService = new BattleShipService();
        battleShipService.start();
    }

    public void start() {
        ShipFactory shipFactory = new ShipFactory();

        FieldCreator fieldCreator = new FieldCreator();
        String[][] strings = fieldCreator.create();
        String[][] computerField = fieldCreator.createComputerField();
        fieldCreator.printField(strings);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 1; i < 2; i++) {
                for (int j = 2 - i; j > 0; j--) {
                    System.out.print("Input a coordinates of " + i + "Deck Ship: ");
                    System.out.print("Input a head coordinates in format (Letter + number) ");
                    int xHead = Character.toLowerCase(reader.readLine().charAt(0)) - 97;
                    int yHead = Integer.parseInt(reader.readLine());
                    System.out.print("Input a stern coordinates in format (Letter + number) ");
                    int xStern = Character.toLowerCase(reader.readLine().charAt(0)) - 97;
                    int yStern = Integer.parseInt(reader.readLine());
                    try {
                        Ship ship = shipFactory.createShip(i, xHead, yHead, xStern, yStern);
                        fieldCreator.setShip(strings, ship);
                        fieldCreator.printField(strings);
                    } catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage());
                        j++;
                    }
                }

            }
            while (isGameOver(strings)) {
                System.out.println("input coordinates to Fire in format (letter + number):");
                int xHead = Character.toLowerCase(reader.readLine().charAt(0)) - 97;
                int yHead = Integer.parseInt(reader.readLine());
                fire(strings, xHead, yHead);
                fieldCreator.printField(strings);
            }
            fieldCreator.printField(strings);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean fire(String[][] field, int x, int y) {
        if (field[x][y].equals("[X]")) {
            field[x][y] = "[*]";
            if (isAlive(field, x, y)) {
                return true;
            } else {
                for (int i = x - 1; i <= x + 1; i++) {
                    for (int j = y - 1; j <= y + 1; j++) {
                        try {
                            if (field[i][j].equals("[ ]") || field[i][j].equals("[0]") || field[i][j].equals("[*]")) {
                                field[i][j] = "[*]";
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            continue;
                        }
                    }
                }
                return true;
            }

        } else if (field[x][y].equals("[ ]")) {
            field[x][y] = "[0]";
            return false;
        } else if (field[x][y].equals("[*]") || field[x][y].equals("[0]")) {
            System.out.println("This coordinates was already fired!");
            return true;
        }
        throw new IllegalArgumentException("Wrong");
    }

    private boolean isAlive(String[][] field, int x, int y) {
        boolean flag = false;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                try {
                    if (field[i][j].equals("[X]")) {
                        flag = true;
                        break;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    continue;
                }
            }
        }
        return flag;
    }

    private boolean isGameOver(String[][] field) {
        boolean winFlag = false;
        for (int i = 0; i < field.length - 1; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j].equals("[X]")) {
                    winFlag = true;
                }
            }
        }
        return winFlag;
    }
}
