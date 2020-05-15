package com.moogflow.alg.search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 3, 5, 9, 12};
        BinarySearch binarySearch = new BinarySearch();
        int i = binarySearch.binarySearchRecursion(arr, 10);
        int i2 = binarySearch.binarySearchLoop(arr, 10);
        System.out.println(i);
        System.out.println(i2);
    }

    /**
     *  利用递归实现二分法
     * @param arr
     * @param target
     * @return
     */
    public int binarySearchRecursion(int[] arr, int target) {
        return binarySearch(arr, 0, arr.length - 1, target);
    }

    public int binarySearch(int[] arr, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;

        int mindValue = arr[mid];
        if (mindValue < target) {   // 目标数 大于查找范围   向右查找
            return binarySearch(arr, mid, right - 1, target);
        } else if (mindValue > target) {
            return binarySearch(arr, left, mid + 1, target);
        } else {
            return mid;
        }
    }


    /**
     *  利用遍历实现二分法
     * @param arr
     * @param target
     * @return
     */
    public int binarySearchLoop(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left > right) {
            int mid = (left + right) / 2;
            if (target == arr[mid]) {
                return mid;
            }
            if (target < arr[mid]) {
                right = mid;
            }
            if (target > arr[mid]) {
                left = mid;
            }
        }
        return -1;

    }

}
