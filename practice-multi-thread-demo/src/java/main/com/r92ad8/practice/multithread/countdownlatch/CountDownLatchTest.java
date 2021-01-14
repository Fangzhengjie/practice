package com.r92ad8.practice.multithread.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " execute.....");
            countDownLatch.countDown();
        }).start();
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " execute.....");
            countDownLatch.countDown();
        }).start();
        try {
            countDownLatch.await(1000, TimeUnit.MILLISECONDS);
            System.out.println(Thread.currentThread().getName() + "execute end");
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}
