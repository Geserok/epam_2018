package com.kav.epam.lesson13;

/**
 * Created by zstudent on 16/11/2018.
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


