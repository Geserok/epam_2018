package com.kav.epam.lesson13;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zstudent on 16/11/2018.
 */
public class LockDemo implements Runnable{
public static int count;
private static Lock lock = new ReentrantLock();
    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            lock.lock();
            count++;
            lock.unlock();
        }
        System.out.println(count);
    }
}
