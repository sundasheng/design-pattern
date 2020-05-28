package com.example.algorithm.Sort;

import java.util.Arrays;

/**
 * @author sunjing
 * @create 2019-10-18 14:11
 **/

public class Sort {

    /**
     * 最佳情况：T(n) = O(n2)  最差情况：T(n) = O(n2)  平均情况：T(n) = O(n2)
     *
     * @param array
     */
    public static void insertSort(int[] array) {
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preindex = i;
            while (preindex >= 0 && current < array[preindex]) {
                array[preindex + 1] = array[preindex];
                preindex--;
            }
            array[preindex + 1] = current;
        }
    }

    /**
     * 最佳情况：T(n) = O(n2)  最差情况：T(n) = O(n2)  平均情况：T(n) = O(n2)
     *
     * @param array
     */
    public static void selectSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
                int temp = array[min];
                array[min] = array[i];
                array[i] = temp;
            }
        }

    }

    /**
     * 最佳情况：T(n) = O(n)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
     *
     * @param array
     */
    public static void bubbleSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 最佳情况：T(n) = O(nlog2 n)  最坏情况：T(n) = O(nlog2 n)  平均情况：T(n) =O(nlog2n)　
     * @param array
     */
    public static void ShellSort(int[] array) {
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
    }


    public static void QuickSort(int[] array,int start,int end){
        if (array.length < 1 || start < 0 || end >= array.length || start > end) {
           return;
        }
        int smallIndex = partition(array, start, end);
        if (smallIndex > start) {
            QuickSort(array, start, smallIndex - 1);
        }
        if (smallIndex < end) {
            QuickSort(array, smallIndex + 1, end);
        }
    }

    private static int partition(int[] array,int start,int end){
        System.out.println( Math.random());
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        swap(array, pivot, end);
        for (int i = start; i <= end; i++) {
            if (array[i] <= array[end]) {
                smallIndex++;
                if (i > smallIndex) {
                    swap(array, i, smallIndex);
                }
            }
        }
        return smallIndex;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 8, 7, 3, 1, 2, 6, 4, 0};
//        insertSort(array);
//        selectSort(array);
//        bubbleSort(array);
//        ShellSort(array);
        QuickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
