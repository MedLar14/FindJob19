package com.example.demo.cloneTest;

import org.junit.jupiter.api.Test;

public class ThinkInJava {

    /**
     * clone()方法，是在堆中复制一个对象，就像new一个对象一样，这个对象属性和原来的对象一样，只是栈中的引用地址变了
     * 想使用clone()，必须实现Cloneable接口，Cloneable是个标志，就像序列化一样
     * clone()分为浅克隆和深克隆，因为克隆的对象和原来的对象属性一样。如果原对象中属性是引用地址，克隆的也是引用地址，没有克隆引用地址指向的对象
     * 当这个引用地址指向的对象内容改变，所有的引用这个对象的内容也就改变了，这就是浅克隆。
     * 比如 a b c三个对象，a对象中有b的对象属性，c是a的克隆对象，当a中b对象发生了改变，c中的b对象也发生改变
     * 与浅克隆相对应的就是深克隆，深克隆是在引用对象中也实现clone方法，再在对象中指明引用对象也克隆,将引用地址改变
     * 如 a = super.clone()  a.b=b.clone()
     */
    @Test
    public void testBean() {
        Person p1 = new Person(12, "p1", "man");
        Person p2 = (Person) p1.clone();
        System.out.println("Person的String引用地址是否相同" + p1.getName().equals(p2.getName()));
        p1.setName("p2");
        System.out.println("Person的String引用地址是否相同" + p1.getName().equals(p2.getName()));
        System.out.println(p1.toString());
        System.out.println(p2.toString());
    }

    @Test
    public void testGroup() {
        Person p1 = new Person(12, "p1", "man");
        Group g1 = new Group("g1", "g1", p1);
        Group g2 = (Group) g1.clone();
        System.out.println("Group的Person引用地址是否相同" + g1.getPerson().equals(g2.getPerson()));
        p1.setName("p2");
        System.out.println("Group的Person引用地址是否相同" + g1.getPerson().equals(g2.getPerson()));
        System.out.println(g1.toString());
        System.out.println(g2.toString());
    }

    @Test
    public void testSchool() {
        Classs cla1 = new Classs("cla1");
        School sc1 = new School(cla1, "sc1");
        School sc2 = (School) sc1.clone();
        System.out.println(sc1.getStu1() == sc2.getStu1());
        sc1.getStu1().getName();
        sc2.getStu1().getName();
        Classs cla2 = sc1.getStu1();
        cla2.setName("2222");
        System.out.println(sc1.getStu1() == sc2.getStu1());
        sc1.getStu1().getName();
        sc2.getStu1().getName();
    }

}