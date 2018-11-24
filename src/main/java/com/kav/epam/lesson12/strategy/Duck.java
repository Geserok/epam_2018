package com.kav.epam.lesson12.strategy;

/**
 * Duck
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public abstract class Duck {
    FlyBehavior flyBehavior;
    SwimBehavior swimBehavior;
    public Duck() {
    }

    public abstract void display();

    public void performSwim(){
        swimBehavior.swimable();
    }

    public void performFly() {
        flyBehavior.flyable();
    }

}
