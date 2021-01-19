package com.r92ad8.practice.multithread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("do then callback....");
        return "ok";
    }

    public static void main(String[] args) {
        Callable<String> callableTest = new CallableTest();
        //由Callable<String>创建一个FutureTask<String>对象：
        FutureTask<String> futureTask = new FutureTask<String>(callableTest);
        //注释：FutureTask<String>是一个包装器，它通过接受Callable<String>来创建，它同时实现了Future和Runnable接口。
        //由FutureTask<String>创建一个Thread对象：
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            String result = futureTask.get();
            System.out.println("futureTask response " + result);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
