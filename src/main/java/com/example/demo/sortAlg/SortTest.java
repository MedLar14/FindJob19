package com.example.demo.sortAlg;

import java.util.Arrays;

public class SortTest {

    public static void main(String[] args) {
        int[] testExample = new int[]{47, 7, 1, 1, 11, 7, 6, 14, 0};
        SortAlgorithm sort = new SortAlgorithm();
        int[] result = sort.RadixSort(testExample);
        System.out.println(Arrays.toString(result));
    }

}
