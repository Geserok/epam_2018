package com.kav.epam.homework7;

import java.util.Scanner;

public class BattleShipService {


    public static void main(String[] args) {
        BattleShipService battleShipService = new BattleShipService();
        battleShipService.start();
    }

    public void start(){
        ShipFactory shipFactory = new ShipFactory();

        FieldCreator fieldCreator = new FieldCreator();
        String[][] strings = fieldCreator.create();
        fieldCreator.printField(strings);
        for (int i = 1; i < 5; i++) {
            for (int j = 5 - i; j > 0 ; j--) {
                Scanner in = new Scanner(System.in);
                System.out.print("Input a coordinates of " + i + "Deck Ship: ");
                int xHead = in.nextInt();
                int yHead = in.nextInt();
                int xStern = in.nextInt();
                int yStern = in.nextInt();
                try {
                    Ship ship = shipFactory.createShip(i, xHead, yHead, xStern, yStern);
                    fieldCreator.setShip(strings,ship);
                    fieldCreator.printField(strings);
                } catch (IllegalArgumentException e){
                    System.err.println(e.getMessage());
                    j++;
                }
            }

        }
        fieldCreator.printField(strings);
    }

    private boolean fire(String[][] field, int x, int y) {
        if (field[x][y].equals("[X]")) {
            field[x][y] = "[*]";
            if (isAlive(field, x, y)) {
                return true;
            } else {
                for (int i = x - 1; i <= x + 1; i++) {
                    for (int j = y - 1; j <= y + 1; j++) {
                        field[i][j] = "[*]";
                    }
                }
                return true;
            }

        } else if (field[x][y].equals("[ ]")) {
            field[x][y] = "[0]";
            return false;
        }
        throw new IllegalArgumentException("Wrong");
    }

    private boolean isAlive(String[][] field, int x, int y) {
        boolean flag = false;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (field[i][j].equals("[X]")) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    private boolean isGameOver(String[][] field){
        boolean winFlag = true;
        for (int i = 0; i < field.length - 1; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j].equals("[X]")){
                    winFlag = false;
                }
            }
        }
        return winFlag;
    }
}
