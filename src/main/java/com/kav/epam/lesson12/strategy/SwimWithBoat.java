package com.kav.epam.lesson12.strategy;

/**
 * SwimWithBoat
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class SwimWithBoat implements SwimBehavior {

    @Override
    public void swimable() {
        System.out.println("I am swimming on the boat");
    }
}
