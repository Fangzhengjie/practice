package com.r92ad8.practice.multithread.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("execute");
            }
        }, 1);


//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("execute");
//            }
//        }, new Date());
//
//
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("execute");
//            }
//        }, new Date(), 1000);
//
//
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("execute");
//            }
//        }, 1000, 2000);
//
//        timer.scheduleAtFixedRate(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("execute");
//            }
//        }, 1000, 1000);
//
//        timer.scheduleAtFixedRate(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("execute");
//            }
//        }, new Date(), 1000);
    }
}
