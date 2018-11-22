package com.kav.epam.homework8.casino;

import java.util.concurrent.Callable;

/**
 * Created by zstudent on 19/11/2018.
 */
public class Horse implements Callable<Integer>{
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
    public Integer call() throws Exception {
        int i = 0;
        while (1000 > speed * i + (accelerate * Math.pow(i,2))){
            i++;
        }
        return i;
    }

    public String getName() {
        return name;
    }
}
