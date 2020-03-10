package com.example.demo.sort10;

import org.springframework.stereotype.Component;

import java.lang.annotation.Target;
import java.util.Arrays;

public class SortAll {

    /**
     * 冒泡
     *
     * @param array
     */
    public int[] BubbleSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int tmp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }

    /**
     * 选择排序
     *
     * @param array
     * @return
     */
    public int[] SelectSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int minIndex = 0;
        int tmp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            tmp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = tmp;
        }
        return array;
    }

    /**
     * 插入排序
     *
     * @param array
     * @return
     */
    public int[] InsertSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int index = 0;
        int tmp = 0;
        for (int i = 1; i < array.length; i++) {
            tmp = array[i];
            index = i - 1;
            while (index >= 0 && array[index] > tmp) {
                array[index + 1] = array[index];
                index--;
            }
            array[index + 1] = tmp;
        }
        return array;
    }

    /**
     * 希尔排序（中间使用插入排序）
     *
     * @param array
     * @return
     */
    public int[] ShellSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int separation = array.length / 2;
        int tmp = 0;
        int index = 0;
        while (separation > 0) {
            for (int i = separation; i < array.length; i++) {
                tmp = array[i];
                index = i - separation;
                while (index >= 0 && array[index] > tmp) {
                    array[index + separation] = array[index];
                    index = index - separation;
                }
                array[index + separation] = tmp;
            }
            separation = separation / 2;
        }
        return array;
    }

    /**
     * 归并排序(分半后合并，调用自身)
     *
     * @param array
     * @return
     */
    public int[] MergeSort(int[] array) {
        if (array.length < 2) {
            return array;
        }
        int separa = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, separa);
        int[] right = Arrays.copyOfRange(array, separa, array.length);
        return MergeLeftRight(MergeSort(left), MergeSort(right));
    }

    /**
     * 归并排序-合并子方法
     *
     * @param left
     * @param right
     * @return
     */
    private int[] MergeLeftRight(int[] left, int[] right) {
        int[] merge = new int[left.length + right.length];
        int minLeft = 0;
        int minRight = 0;
        for (int i = 0; i < merge.length; i++) {
            if (minLeft > left.length - 1) {
                merge[i] = right[minRight++];
            } else if (minRight > right.length - 1) {
                merge[i] = left[minLeft++];
            } else if (left[minLeft] < right[minRight]) {
                merge[i] = left[minLeft++];
            } else {
                merge[i] = right[minRight++];
            }
        }
        return merge;
    }

    /**
     * 快速排序-选中基准，按基准分为两边
     * 涉及递归
     *
     * @param array
     * @return
     */
    public int[] QuickSort(int[] array) {
        if (array.length < 2) {
            return array;
        }
        QuickSortWithStartEnd(array, 0, array.length);
        return array;
    }

    private void QuickSortWithStartEnd(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int partitionIndex = Partition(array, start, end);
        QuickSortWithStartEnd(array, start, partitionIndex - 1);
        QuickSortWithStartEnd(array, partitionIndex + 1, end);
    }

    /**
     * 快速排序-分区，双边指针，前后交替扫描
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    private int Partition(int[] array, int start, int end) {
        int stardard = array[end - 1];
        int index = start;
        for (int i = start + 1; i < end; i++) {
            if (array[i] < stardard) {
                swap(array, i, index);
                index++;
            }
        }
        return 0;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    /**
     * 快速排序方法
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    public  int[] QuickSort1(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end) return null;
        int smallIndex = partition1(array, start, end);
        if (smallIndex > start)
            QuickSort1(array, start, smallIndex - 1);
        if (smallIndex < end)
            QuickSort1(array, smallIndex + 1, end);
        return array;
    }

    /**
     * 快速排序算法——partition
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    private int partition1(int[] array, int start, int end) {
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        swap(array, pivot, end);
        for (int i = start; i <= end; i++)
            if (array[i] <= array[end]) {
                smallIndex++;
               // if (i > smallIndex)
                    swap(array, i, smallIndex);
            }
        return smallIndex;
    }


}