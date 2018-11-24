package com.kav.epam.lesson4;

/**
 * Cat interface
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public interface CatInterface {

    default void getEat(){
        System.out.println("I am eating...");
    }
}
