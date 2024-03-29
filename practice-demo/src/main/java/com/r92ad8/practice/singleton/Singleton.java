package com.r92ad8.practice.singleton;


public class Singleton {

    private Singleton() {
    }

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }


    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
