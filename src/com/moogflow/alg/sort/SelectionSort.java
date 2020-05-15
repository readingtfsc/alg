package com.moogflow.alg.sort;

/**
 * 选择排序 不稳定排序算法
 * 特点：算法简单直观
 * 原理：在待排序的元素中选出最小/最大的元素,
 * 时间复杂度：
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 8, 3, 7, 4, 6,10000000, 5, 5, 100, 99, 23, 1};
        sort(arr);
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = 0;
            for (int j = i; j < arr.length - 1; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;

            }
        }

        //打印结果
        for (int i : arr) {
            System.out.printf("%d ,", i);
        }
    }
}
