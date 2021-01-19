package com.r92ad8.practice.multithread.semaphore;

import org.apache.catalina.Executor;
import org.apache.tomcat.util.ExceptionUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {

    public static void main(String[] args) {
        //模拟6个停车位,
        Semaphore semaphore = new Semaphore(6);
        //启动8个线程,
        ExecutorService exec = Executors.newFixedThreadPool(8);
        //模拟8辆车去抢
        for (int i = 1; i < 9; i++) {
            final int no = i;
            exec.submit(() -> {
                try {
                    //占用车位;
                    semaphore.acquire();
                    System.out.println("第" + no + "辆车，车牌号：" + Thread.currentThread().getName() + "抢到了车位");
                    //停车2s
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("第" + no + "辆车，车牌号：" + Thread.currentThread().getName() + "停了2s后离开");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //释放掉, 离开停车位
                    semaphore.release();
                }
            });
        }
        exec.shutdown();
    }
}
