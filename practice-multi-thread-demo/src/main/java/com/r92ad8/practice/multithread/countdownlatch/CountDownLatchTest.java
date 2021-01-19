package com.r92ad8.practice.multithread.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {

    // 十名选手
    private static final ExecutorService exec = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch begin = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            final int no = i + 1;
            exec.submit(() -> {
                try {
                    begin.await();
                    Thread.sleep((long) (Math.random() * 10000));
                    System.out.println( no + "号到达终点");
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                } finally {
                    end.countDown();
                }
            });
        }
        System.out.println("比赛开始");
        begin.countDown(); // begin减一，开始游戏
        end.await();// 等待end变为0，即所有选手到达终点
        System.out.println("比赛结束");
        exec.shutdown();
    }
}
