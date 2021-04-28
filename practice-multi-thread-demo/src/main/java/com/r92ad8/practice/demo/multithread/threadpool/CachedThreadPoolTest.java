package com.r92ad8.practice.demo.multithread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolTest {

    //可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
    public static final ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            cachedThreadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " execute.....");
            });
        }
    }

}
