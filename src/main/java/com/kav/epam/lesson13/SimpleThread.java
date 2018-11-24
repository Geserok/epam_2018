package com.kav.epam.lesson13;

/**
 * SimpleThread
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class SimpleThread implements Runnable {
    public int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 1_000_000; i++) {
            count++;
        }
        System.out.println(count);
    }
}


