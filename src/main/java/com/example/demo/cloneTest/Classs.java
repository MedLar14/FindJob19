package com.example.demo.cloneTest;

public class Classs implements Cloneable {
    private int stuCount = 30;
    private String name;

    public Classs(String name) {
        this.name = name;
    }

    public void getName() {
        System.out.println(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
