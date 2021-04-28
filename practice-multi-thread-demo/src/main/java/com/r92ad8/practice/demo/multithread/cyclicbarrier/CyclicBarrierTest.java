package com.r92ad8.practice.demo.multithread.cyclicbarrier;

import java.util.concurrent.*;

public class CyclicBarrierTest {
    static final ExecutorService exec = Executors.newFixedThreadPool(4);

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, () -> {
            System.out.println("所有准备工作都已完成...........");
        });
        String[] taskArray = new String[]{"启动IDEA", "开启虚拟机", "启动MYSQL", "DEBUG启动SpringBoot项目"};
        for (int i = 0; i < taskArray.length; i++) {
            final int taskNo = i;
            exec.submit(() -> {
                System.out.println("正在进行DEBUG调试的准备工作:"+taskArray[taskNo]+"");
                try {
                    TimeUnit.SECONDS.sleep(10);
                    System.out.println("准备工作:"+taskArray[taskNo]+"已完成");
                    cyclicBarrier.await();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        exec.shutdown();
    }


}
