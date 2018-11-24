package com.kav.epam.lesson13;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Solution
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class Solution {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newCachedThreadPool();
        ex.execute(new SimpleThread());
        ex.execute(new SimpleThread());
        ex.shutdown();

        ExecutorService ex2 = Executors.newCachedThreadPool();
        Future<Integer> integerFuture = ex2.submit(new CallableThread());
        Future<Integer> integerFuture1 = ex2.submit(new CallableThread());
        try {
            System.out.println("I am already here");
            System.out.println(integerFuture.get());
            System.out.println(integerFuture.isDone());
            System.out.println(integerFuture.get());
            System.out.println(integerFuture1.get());
            System.out.println(integerFuture.isDone());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        ex2.shutdown();

        LockDemo lock1 = new LockDemo();
        LockDemo lock2 = new LockDemo();
        Thread th1 = new Thread(lock1);
        Thread th2 = new Thread(lock2);

        th1.start();
        th2.start();

        AtomicThread atomicThread = new AtomicThread();
        AtomicThread atomicThread1 = new AtomicThread();
        atomicThread.run();
        atomicThread1.run();
    }
}