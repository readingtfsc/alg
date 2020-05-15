package com.moogflow.alg.sort;


/**
 * 冒泡排序  稳定排序算法
 * 原理：相邻的两个元素比较,将最大的元素交换到右端
 * 时间复杂度： On的平方
 */

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 8, 3, 7, 4, 6, 5, 5, 100, 99, 23, 1};
        sort(arr);
    }

    public static void sort(int[] arr) {
        int temp = 0;
        int count = 0;
        for (int j = 0; j <= arr.length - 1; j++) {
            // 内部循环为什么是 arr.len - 1 - j ?
            // 数组第一循环的时候就将最大的数 移动到了 最后一位，所以最后一位不需要再参与比较 所以  -j
            // 因为数组 是当前位 和 下一位进行比较的，防止数组越界
            for (int i = 0; i < arr.length - 1 - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
                count++;
                for (int a : arr) {
                    System.out.printf("%d ,", a);
                }
                System.out.println("");

            }
            System.out.printf("第 %d 次结果\n", count);
            for (int a : arr) {
                System.out.printf("%d ,", a);
            }
            System.out.println("");
        }
        System.out.printf("最多执行了 %d 次\n", count);


        //打印结果
        for (int i : arr) {
            System.out.printf("%d ,", i);
        }
    }

}
