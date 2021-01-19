package com.r92ad8.practice.multithread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorTest {

    //单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
    public static final ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            singleThreadExecutor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " execute.....");
            });
        }
    }
}
