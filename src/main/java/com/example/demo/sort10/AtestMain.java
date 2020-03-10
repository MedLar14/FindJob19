package com.example.demo.sort10;

import java.util.Arrays;

public class AtestMain {

    public static void main(String[] args) {
        int[] testExample = new int[]{47, 7, 1, 11, 7, 6, 14, 0};
        SortAll sort = new SortAll();
        int[] result = sort.QuickSort(testExample);
        System.out.println(Arrays.toString(result));
    }

}
