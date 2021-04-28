package com.r92ad8.practice.demo.multithread.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTest {

    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        Future<String> future = fixedThreadPool.submit(() -> {
            System.out.println("do then callback");
            return "ok";
        });
        try {
            String result = future.get();
            System.out.println("future result =" + result);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
