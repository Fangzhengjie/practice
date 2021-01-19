package com.r92ad8.practice.multithread.threadpool;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ThreadPoolTaskExecutorTest {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
         final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.initialize();
        //无返回值的任务用execute
        executor.execute(()->{
            System.out.println(Thread.currentThread().getName()+"\t is Running.....");
        });

        //有返回值的任务用submit
        Future<String> future =executor.submit(()->{
            System.out.println(Thread.currentThread().getName()+"\t is Running.....");
            return "ok";
        });
        future.get();
    }
}
