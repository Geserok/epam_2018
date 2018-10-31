package com.kav.epam.lesson12.strategy;

/**
 * Created by zstudent on 15/10/2018.
 */
public abstract class Duck {
    FlyBehavior flyBehavior;
    SwimBehavior swimBehavior;
    public Duck() {
    }

    public abstract void display();

    public void perfomSwim(){
        swimBehavior.swimable();
    }

    public void performFly() {
        flyBehavior.flyable();
    }

}
