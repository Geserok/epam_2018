package com.kav.epam.lesson12.strategy;

/**
 * Swim
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class Swim implements SwimBehavior {

    @Override
    public void swimable() {
        System.out.println("I am swim");
    }
}
