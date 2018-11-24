package com.kav.epam.lesson12.strategy;

/**
 * RubberDuck
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
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

