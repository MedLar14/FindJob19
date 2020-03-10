package com.example.demo.sort10;

import java.util.Arrays;

public class AtestMain {

    public static void main(String[] args) {
        int[] testExample = new int[]{47, 52, 11, 3, 1, 4, 7, 1, 7, 7, 6, 14, 0};
        SortAll sort = new SortAll();
        int[] result = sort.QuickSort1(testExample,0,12);
        System.out.println(Arrays.toString(result));
    }

}
