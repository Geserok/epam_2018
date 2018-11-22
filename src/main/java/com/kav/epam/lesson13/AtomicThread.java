package com.kav.epam.lesson13;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zstudent on 16/11/2018.
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
