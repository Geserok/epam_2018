package com.kav.epam.homework7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


import static com.kav.epam.homework7.FieldCreator.printField;

public class Person extends Player{
    ArrayList<Ship> personShipPool = new ArrayList<>();

    @Override
    public String[][] autoSetShips() {
        Player player = new Player();
        String[][] strings = player.autoSetShips();
        shipPool = getShipPool();
        return strings;
    }

    @Override
    public String[][] manualSetShips() {
        ShipFactory shipFactory = new ShipFactory();

        FieldCreator fieldCreator = new FieldCreator();
        String[][] personField = fieldCreator.create();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 1; i < 5; i++) {
                for (int j = 5 - i; j > 0; j--) {
                    System.out.print("Input a coordinates of " + i + " Deck Ship: ");
                    System.out.print("Input a head coordinates in format (Letter + number + direction(n, s, w, e)) ");
                    try {
                        int xHead = Character.toLowerCase(reader.readLine().charAt(0)) - 97;
                        int yHead = Integer.parseInt(reader.readLine());
                        String direct = reader.readLine();

                        Ship ship = shipFactory.createShip(i, xHead, yHead, direct);
                        fieldCreator.setShip(personField, ship);
                        shipPool.add(ship);
                        printField(personField);
                    } catch (IllegalArgumentException | IOException e) {
                        System.err.println(e.getMessage());
                        j++;
                    }
                }
            }
            printField(personField);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personField;
    }

    public ArrayList<Ship> getShipPool() {
        return personShipPool;
    }

}