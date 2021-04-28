package com.r92ad8.practice.demo.multithread.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {
    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        FutureTask<String> futureTask = new FutureTask<String>(() -> {
            return "ok";
        });
        fixedThreadPool.submit(futureTask);
        try {
            String result = futureTask.get();
            System.out.println("futureTask result=" + result);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
