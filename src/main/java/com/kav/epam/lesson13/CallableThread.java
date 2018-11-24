package com.kav.epam.lesson13;

import java.util.concurrent.Callable;

/**
 * CallableThread
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
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
