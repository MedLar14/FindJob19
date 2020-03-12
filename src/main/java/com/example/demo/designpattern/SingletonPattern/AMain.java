package com.example.demo.designpattern.SingletonPattern;

public class AMain {
    public static void main(String[] args) {
        Singleton_1 s_1 = Singleton_1.getInstance3();
        s_1.show();
        Singleton_2 s_2 = Singleton_2.getInstance();
        s_2.show();
    }
}
