package com.r92ad8.practice.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ThreadPool {

    public  static void main(String[] args){
        ThreadFactory threadFactory=new ThreadFactoryBuilder().build();
        Executors.newCachedThreadPool(threadFactory);
    }
}
