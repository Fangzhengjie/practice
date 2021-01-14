package com.r92ad8.practice.multithread.runnable;

import java.util.concurrent.Executors;

public class TestRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("do something............");
    }

    public static void main(String[] args) {
        TestRunnable runnableThread =new TestRunnable();
        Thread thread1 =new Thread(runnableThread);
        Thread thread2 =new Thread(runnableThread);
        Thread thread3 =new Thread(runnableThread);
        Thread thread4 =new Thread(runnableThread);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
