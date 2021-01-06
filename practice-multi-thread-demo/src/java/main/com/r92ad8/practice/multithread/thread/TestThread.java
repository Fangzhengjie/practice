package com.r92ad8.practice.multithread.thread;

public class TestThread extends Thread{

    public static void main(String[] args) {
        TestThread thread1 = new TestThread();
        TestThread thread2 =new TestThread();
        TestThread thread3 = new TestThread();
        TestThread thread4 =new TestThread();
        thread1.start();
        thread2.start();
        thread4.start();
        thread4.start();
    }
}
