package com.kav.epam.lesson4;

/**
 * Created by zstudent on 24/09/2018.
 */
public interface CatInterface {

    default void getEat(){
        System.out.println("I am eating...");
    }
}
