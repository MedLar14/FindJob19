package com.example.demo.cloneTest;

public class School implements Cloneable {
    private Classs stu1;
    private String name;

    public School(Classs stu1, String name) {
        this.stu1 = stu1;
        this.name = name;
    }

    public void setStu1(Classs stu1) {
        this.stu1 = stu1;
    }

    protected Object clone() {
        School a = null;
        try {
            a = (School) super.clone();
            a.setStu1((Classs) stu1.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return a;
    }

    public Classs getStu1() {
        return stu1;
    }

}
