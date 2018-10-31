package com.kav.epam.lesson12.strategy;

/**
 * Created by zstudent on 15/10/2018.
 */
public class FlyWithWings implements FlyBehavior{

    @Override
    public void flyable() {
        System.out.println("I am fly");
    }
}
