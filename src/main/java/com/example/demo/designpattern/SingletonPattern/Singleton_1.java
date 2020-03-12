package com.example.demo.designpattern.SingletonPattern;

public class Singleton_1 {
    private Singleton_1() {
    }

    private static Singleton_1 instace = null;

    public static Singleton_1 getInstance() {
        if (instace == null) {
            instace = new Singleton_1();
        }
        return instace;
    }

    public void show() {
        System.out.println("hello1");
    }

    public static synchronized Singleton_1 getInstance2() {
        if (instace == null) {
            instace = new Singleton_1();
        }
        return instace;
    }

    public static Singleton_1 getInstance3() {
        if (instace == null) {
            synchronized (Singleton_1.class) {
                if (instace == null) {
                    instace = new Singleton_1();
                }
            }
        }
        return instace;
    }

}
