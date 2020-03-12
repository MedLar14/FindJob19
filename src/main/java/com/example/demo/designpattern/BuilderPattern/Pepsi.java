package com.example.demo.designpattern.BuilderPattern;

public class Pepsi extends ColdDrink {
    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 15.0f;
    }
}
