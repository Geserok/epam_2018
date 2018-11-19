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
        String[][] strings = fieldCreator.create();
        String[][] computerField = fieldCreator.createComputerField();
        fieldCreator.printField(strings);

        Ship[] shipPool = new Ship[2];
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
                        fieldCreator.setShip(strings, ship);
                        fieldCreator.printField(strings);
                    } catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage());
                        j++;
                    }
                }

            }*/
            Ship ship = shipFactory.createShip(2, Character.toLowerCase('a') - 97, 1, "s");
            Ship ship2 = shipFactory.createShip(1, Character.toLowerCase('e') - 97, 3, "e");
            fieldCreator.setShip(strings, ship);
            fieldCreator.setShip(strings, ship2);
            shipPool[0] = ship;
            shipPool[1] = ship2;
            fieldCreator.printField(strings);


            while (!isGameOver(strings)) {
                System.out.println("input coordinates to Fire in format (letter + number):");
                int xHead = Character.toLowerCase(reader.readLine().charAt(0)) - 97;
                int yHead = Integer.parseInt(reader.readLine());
                fire(strings, shipPool, xHead, yHead);
                fieldCreator.printField(strings);
            }
            fieldCreator.printField(strings);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean fire(String[][] field, Ship[] shipPool, int x, int y) {
        try {
            coordinateCheck(x, y);
        } catch (IllegalArgumentException e){
            System.out.println("Coordinates is out of range!");
            return true;
        }
        boolean fireFlag = false;
        Ship ship = null;


        for (Ship aShipPool : shipPool) {
            ArrayList<String> coordinates = aShipPool.getCoordinates();
            for (String coordinate : coordinates) {
                if (coordinate.equals(String.valueOf(x) + y)) {
                    fireFlag = true;
                    ship = aShipPool;
                    break;
                }
            }
        }

        if (fireFlag == true) {
            if (field[x][y].equals("[X]")) {
                field[x][y] = "[*]";
                ship.removeLife();
                if (ship.lives > 0) {
                    return true;
                } else {
                    if (isGameOver(field)){
                        System.out.println("Game is over! Do you want to remake? Press y or n");
                        remake();
                    }
                    ArrayList<String> coordinates = ship.getCoordinates();

                    for (String coordinate : coordinates) {
                        for (int i = Integer.parseInt(String.valueOf(
                                coordinate.toCharArray()[0])) - 1; i < Integer.parseInt(
                                String.valueOf(coordinate.toCharArray()[0])) + 2; i++) {
                            for (int j = Integer.parseInt(String.valueOf(coordinate.toCharArray()[1])) - 1;
                                 j < Integer.parseInt(String.valueOf(coordinate.toCharArray()[1])) + 2; j++) {
                                try {
                                    if (j > 0 && j < 10) {
                                        field[i][j] = "[0]";
                                    }
                                } catch (ArrayIndexOutOfBoundsException e) {

                                }

                            }
                        }
                    }
                    for (String coordinate : coordinates) {
                        try {
                            field[Integer.parseInt(String.valueOf(coordinate.toCharArray()[0]))]
                                    [Integer.parseInt(String.valueOf(coordinate.toCharArray()[1]))] = "[*]";
                        } catch (ArrayIndexOutOfBoundsException e) {

                        }
                    }
                    return true;
                }
            } else if (field[x][y].equals("[*]")) {
                System.out.println("This coordinates were already fired");
                return true;
            }
        } else {
            if (field[x][y].equals("[0]")) {
                System.out.println("This coordinates were already fired");
                return true;
            } else if (field[x][y].equals("[ ]")) {
                field[x][y] = "[0]";
                return false;
            }

        }
        return fireFlag;
    }

    private void coordinateCheck(int x, int y){
        if (x < 0 || y < 0 || x > 10 || y > 10){
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
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            decision = reader.readLine();
            if (decision.equalsIgnoreCase("y")) {
                BattleShipService battleShipService = new BattleShipService();
                battleShipService.start();
            } else if (decision.equalsIgnoreCase("n")){
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
