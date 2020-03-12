package com.example.demo.designpattern.BuilderPattern;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private List<Item> itemList = new ArrayList<>();

    public void addItem(Item item) {
        itemList.add(item);
    }

    public float getPrice() {
        float price = 0;
        for (Item item : itemList) {
            price = price + item.price();
        }
        return price;
    }

    public void show() {
        for (Item item : itemList) {
            System.out.print("Item : " + item.name());
            System.out.print(", Packing : " + item.packing().pack());
            System.out.println(", Price : " + item.price());
        }
    }
}
