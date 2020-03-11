package com.example.demo.designpattern.SingletonPattern;

public class Singleton_2 {
    private Singleton_2() {
    }

    private static Singleton_2 instace = new Singleton_2();

    public static Singleton_2 getInstance() {
        return instace;
    }

    public void show() {
        System.out.println("hello2");
    }

}
