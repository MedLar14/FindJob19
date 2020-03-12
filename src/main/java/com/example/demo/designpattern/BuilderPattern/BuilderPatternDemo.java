package com.example.demo.designpattern.BuilderPattern;

public class BuilderPatternDemo {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.show();
        System.out.println("Total Cost: " + vegMeal.getPrice());

        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("\n\nNon-Veg Meal");
        nonVegMeal.show();
        System.out.println("Total Cost: " + nonVegMeal.getPrice());
    }
}
