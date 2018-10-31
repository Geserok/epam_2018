package com.kav.epam.lesson12.strategy;

/**
 * Created by zstudent on 15/10/2018.
 */
public class RubberDuck extends Duck {
    public RubberDuck() {
        swimBehavior = new SwimWithBoat();
        flyBehavior = () -> System.out.println("I can't fly");
    }

    @Override
    public void display() {
        System.out.println("I am rubber duck");
    }
}

