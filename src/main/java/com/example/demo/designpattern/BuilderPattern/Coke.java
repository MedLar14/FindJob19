package com.example.demo.designpattern.BuilderPattern;

public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 10.f;
    }
}
