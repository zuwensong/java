package com.zuwen.thread.util;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的四种方式: Extend、Runnable、Callable、线程池
 */
public class ThreadCreateDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread thread1 = new ThreadCreateDemo().new Thread1();
        Thread thread2 = new Thread(new ThreadCreateDemo().new Thread2());

        FutureTask<String> ft = new FutureTask<>(new ThreadCreateDemo().new Thread3());
        Thread thread3 = new Thread(ft);
        thread1.start();
        thread2.start();
        thread3.start();
        String str = ft.get();
        System.out.println(str);
    }

    class Thread1 extends Thread {

        @Override
        public void run() {
            System.out.println("extend Thread to create thread...");
        }
    }

    class Thread2 implements Runnable {

        @Override
        public void run() {
            System.out.println("implement Runnable to create thread...");
        }
    }

    class Thread3 implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "implement Callable to create thread...";
        }
    }
}
