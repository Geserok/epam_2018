package com.kav.epam.lesson12.strategy;

/**
 * FlyWithWings
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class FlyWithWings implements FlyBehavior{

    @Override
    public void flyable() {
        System.out.println("I am fly");
    }
}
