package com.kav.epam.homework8.casino;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * Created by zstudent on 19/11/2018.
 */
public class HorseRacing {
    public static void main(String[] args) {
        HorseRacing horseRacing = new HorseRacing();
        BankAccount bankAccount = new BankAccount(BigDecimal.valueOf(100));
        horseRacing.start(bankAccount);
    }

    public void start(BankAccount bankAccount) {

        Horse[] horses = new Horse[5];
        Horse bethany = new Horse("Bethany");
        Horse kitty = new Horse("Kitty");
        Horse sweet = new Horse("Sweet");
        Horse rocket = new Horse("Rocket");
        Horse bullet = new Horse("Bullet");
        horses[0] = bethany;
        horses[1] = kitty;
        horses[2] = sweet;
        horses[3] = rocket;
        horses[4] = bullet;

        for (Horse horse : horses) {
            System.out.println(horse.getName() + " have start speed: " +
                    horse.speed + " accelerate: " + horse.accelerate);
        }
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            boolean bet = bet(horses, bankAccount);
            if (bet == true) {
                System.out.println("You won! Now your cash is: " + bankAccount.getCashAccount());
            } else {
                System.out.println("You lost! Now you cash is: " + bankAccount.getCashAccount());
            }
            System.out.println("do u want to play again? y or n");

            String next = null;
            try {
                next = bf.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (next.equalsIgnoreCase("y")) {
                continue;
            } else {
                System.out.println("See u later!");
                System.exit(1);
            }
        }
    }


    private boolean bet(Horse[] horses, BankAccount bankAccount) {
        String nameOfBet = null;
        BigDecimal betMoney = BigDecimal.valueOf(1l);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("input Horse name: ");
            nameOfBet = reader.readLine();
            System.out.println("input your bet. Your max bet is: " + bankAccount.getCashAccount());
            betMoney = BigDecimal.valueOf(Long.parseLong(reader.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Future<Integer> result = null;
        ExecutorService ex = Executors.newCachedThreadPool();
        int timeOfWinner = 1000;
        String nameOfWinner = null;
        try {
            for (Horse horse : horses) {
                result = ex.submit(horse);
                if (result.get() < timeOfWinner) {
                    timeOfWinner = result.get();
                    nameOfWinner = horse.getName();
                }
                System.out.println(horse.getName() + " result " + result.get());
            }
            System.out.println(nameOfWinner + " win with result: " + timeOfWinner);
            if (nameOfWinner.equalsIgnoreCase(nameOfBet)) {
                bankAccount.deposit(betMoney.multiply(BigDecimal.valueOf(5l)));
                return true;
            } else {
                bankAccount.subs(betMoney);
                return false;
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            ex.shutdown();
        }
        return false;
    }
}
