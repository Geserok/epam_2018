package com.kav.epam.lesson13;

import java.util.concurrent.Callable;

/**
 * Created by zstudent on 16/11/2018.
 */
public class CallableThread implements Callable {
    public int count = 0;
    @Override
    public Integer call() {
        for (int i = 0; i < 1_000_000; i++) {
            count++;
        }

        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return count;
    }
}
