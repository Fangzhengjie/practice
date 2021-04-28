package com.r92ad8.practice.demo.multithread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadScheduledExecutorTest {
    public static final ExecutorService singleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            singleThreadScheduledExecutor.execute(()->{
                System.out.println(Thread.currentThread().getName()+" execute.....");
            });
        }
    }
}
