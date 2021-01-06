package com.r92ad8.practice.multithread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolTest {

    //定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
    public static final ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            fixedThreadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " execute.....");
            });
        }
    }
}
