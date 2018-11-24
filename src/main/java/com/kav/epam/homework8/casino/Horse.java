package com.kav.epam.homework8.casino;

import java.util.concurrent.Callable;

/**
 * Horse for HorseRacing
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class Horse implements Callable<Integer> {
    double speed;
    double accelerate;
    String name;

    public Horse(String name) {
        this.name = name;
        double random = Math.random();
        this.speed = random * 10;
        this.accelerate = (1 - random) * 10;
    }

    @Override
    public Integer call() {
        int i = 0;
        while (1000 > speed * i + (accelerate * Math.pow(i, 2))) {
            i++;
        }
        return i;
    }

    public String getName() {
        return name;
    }
}
