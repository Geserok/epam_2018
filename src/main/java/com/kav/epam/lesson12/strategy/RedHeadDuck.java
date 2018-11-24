package com.kav.epam.lesson12.strategy;

/**
 * Animal
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class RedHeadDuck extends Duck {
    public RedHeadDuck() {
        flyBehavior = new FlyWithWings();
        swimBehavior = new Swim();
    }

    @Override
    public void display() {
        System.out.println("I am redhead duck");
    }
}
