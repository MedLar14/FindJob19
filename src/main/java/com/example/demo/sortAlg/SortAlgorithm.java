package com.example.demo.sortAlg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortAlgorithm {

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
        QuickSortWithStartEnd(array, 0, array.length - 1);
        return array;
    }

    private void QuickSortWithStartEnd(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int partitionIndex = PartitionScan(array, start, end);
        QuickSortWithStartEnd(array, start, partitionIndex - 1);
        QuickSortWithStartEnd(array, partitionIndex + 1, end);
    }

    /**
     * 快速排序-分区，从前往后扫描
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    private int Partition(int[] array, int start, int end) {
        int stardard = array[end - 1];
        int index = start - 1;
        for (int i = start; i < end; i++) {
            //不好理解
            if (array[i] < stardard) {
                index++;
                if (i > index) {
                    swap(array, i, index);
                }
            }
        }
        return index;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 快速排序-分区，双边指针，前后交替扫描
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    private int PartitionScan(int[] array, int start, int end) {
        int datum = array[end];
        //逻辑较为直观s
        while (start < end) {
            while (start < end && array[start] <= datum) {
                start++;
            }
            array[end] = array[start];
            while (start < end && array[end] >= datum) {
                end--;
            }
            array[start] = array[end];
        }
        array[end] = datum;
        return end;
    }

    /**
     * 堆排序-最大堆
     *
     * @param array
     * @return
     */
    public int[] HeapSort(int[] array) {
        int len = array.length;
        //初始化
        buildMaxHeap(array);
        while (len > 0) {
            //最大堆，顶部放到最后
            swap(array, 0, len - 1);
            len--;
            //注意尾部边界
            adjustHeap(array, 0, len - 1);
        }
        return array;
    }

    /**
     * 堆排序-初始化最大堆
     *
     * @param array
     */
    private void buildMaxHeap(int[] array) {
        //非叶子节点开始
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjustHeap(array, i, array.length - 1);
        }
    }

    /**
     * 堆排序-调整最大堆
     *
     * @param array
     * @param i
     * @param bound
     */
    private void adjustHeap(int[] array, int i, int bound) {
        int maxIndex = i;
        //左叶子节点
        if ((2 * i + 1) <= bound && array[2 * i + 1] > array[maxIndex]) {
            maxIndex = 2 * i + 1;
        }
        //右叶子节点
        if ((2 * i + 2) <= bound && array[2 * i + 2] > array[maxIndex]) {
            maxIndex = 2 * i + 2;
        }
        if (maxIndex != i) {
            swap(array, i, maxIndex);
            //继续调整
            adjustHeap(array, maxIndex, bound);
        }
    }

    /**
     * 计数排序
     *
     * @param array
     * @return
     */
    public int[] CountSort(int[] array) {
        int max = array[0];
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                continue;
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        int[] newCount = new int[max - min + 1];
        for (int i = 0; i < array.length; i++) {
            newCount[array[i] - min]++;
        }
        int index = 0;
        for (int i = 0; i < newCount.length; i++) {
            if (newCount[i] <= 0) {
                continue;
            }
            for (int j = 0; j < newCount[i]; j++) {
                array[index] = min + i;
                index++;
            }
        }
        return array;
    }

    /**
     * 桶排序，分而治之，桶内排序使用其他排序算法
     *
     * @param array
     * @return
     */
    public int[] BucketSort(int[] array) {
        int max = array[0];
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                continue;
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        int bucketSize = 5;
        int bucketCount = (max - min) / bucketSize + 1;
        int sizeArra = (int) (bucketCount / 0.7);
        ArrayList<ArrayList<Integer>> bucket = new ArrayList<>(sizeArra);
        //放桶
        for (int i = 0; i < bucketCount; i++) {
            bucket.add(new ArrayList<>());
        }
        for (int i = 0; i < array.length; i++) {
            int index = (array[i] - min) / bucketSize;
            ArrayList<Integer> tmp = bucket.get(index);
            tmp.add(array[i]);
        }
        //桶排序，抽取
        int addIndex = 0;
        for (int i = 0; i < bucketCount; i++) {
            ArrayList<Integer> tmp = bucket.get(i);
            if (tmp != null) {
                //桶内排序
                Collections.sort(tmp);
                for (Integer a : tmp) {
                    array[addIndex] = a;
                    addIndex++;
                }
            }
        }
        return array;
    }

    /**
     * 基数排序
     *
     * @param array
     * @return
     */
    public int[] RadixSort(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        int maxLength = String.valueOf(max).length();
        int bucketCount = 10;
        ArrayList<ArrayList<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            bucket.add(new ArrayList<>());
        }
        for (int i = 0; i < maxLength; i++) {
            //放
            for (int j = 0; j < array.length; j++) {
                int index = (array[j] / (int) Math.pow(10, i) % 10);
                ArrayList<Integer> tmp = bucket.get(index);
                tmp.add(array[j]);
            }
            //取
            int addIndex = 0;
            for (int j = 0; j < bucket.size(); j++) {
                ArrayList<Integer> tmp = bucket.get(j);
                for (Integer tmpInt : tmp) {
                    array[addIndex] = tmpInt;
                    addIndex++;
                }
                tmp.clear();
            }
        }
        return array;
    }


}