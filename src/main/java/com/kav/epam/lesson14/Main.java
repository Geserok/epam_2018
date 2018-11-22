package com.kav.epam.lesson14;

import java.util.HashMap;
import java.util.concurrent.*;

/**
 * Created by zstudent on 19/11/2018.
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String nameOfWinner = null;
        int timeOfWinner = 1000;
        Horse[] horses = new Horse[5];
        Horse bethany = new Horse("Bethany");
        Horse kitty = new Horse("kitty");
        Horse sweet = new Horse("sweet");
        Horse rocket = new Horse("rocket");
        Horse bullet = new Horse("bullet");
        horses[0] = bethany;
        horses[1] = kitty;
        horses[2] = sweet;
        horses[3] = rocket;
        horses[4] = bullet;
        Future<Integer> result = null;
        ExecutorService ex = Executors.newCachedThreadPool();

        for (Horse horse:horses) {
            result = ex.submit(horse);
            if (result.get() < timeOfWinner){
                timeOfWinner = result.get();
                nameOfWinner = horse.getName();
            }
            System.out.println(horse.getName() + " result " + result.get());
        }
        System.out.println(nameOfWinner + " win with result: " + timeOfWinner);
        ex.shutdown();


    }
}
