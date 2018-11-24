package com.kav.epam.lesson13;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicThread
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class AtomicThread implements Runnable {
    public static AtomicInteger count = new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            count.getAndAdd(1);
        }
        System.out.println(count);
    }
}
