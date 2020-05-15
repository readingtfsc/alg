package com.moogflow.alg.search;

public class InterpolationSearch {

    public static void main(String[] args) {

        /**
         *  插值查找计算公式：
         *  int mid = low + (target - arr[low]) / (arr[height] - arr[low]) * (height - low);
         */

        int[] arr = {-1, 0, 3, 5, 9, 12};
        InterpolationSearch interpolationSearch = new InterpolationSearch();
        int i = interpolationSearch.InterpolationSearchRecursion(arr, 20);
        System.out.println(i);
        int i2 = interpolationSearch.InterpolationSearchLoop(arr, 20);
        System.out.println(i2);
    }

    /**
     *  递归实现插值查找
     * @param arr
     * @param target
     * @return
     */

    public int InterpolationSearchRecursion(int[] arr, int target) {
        return InterpolationSearch(arr, 0, arr.length - 1, target);
    }


    /**
     *  递归实现插值查找
     * @param arr
     * @param target
     * @return
     */

    public int InterpolationSearch(int[] arr, int low, int height, int target) {
        if (low > height) {
            return -1;
        }
        //计算靠近target值的节点
        int mid = low + (target - arr[low]) / (arr[height] - arr[low]) * (height - low);

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) { //
            return InterpolationSearch(arr, mid, height - 1, target);
        } else {
            return InterpolationSearch(arr, low, mid + 1, target);
        }
    }


    public int InterpolationSearchLoop(int[] arr, int target) {
        int low = 0;
        int height = arr.length - 1;



        while (low > height) {
            //计算靠近target值的节点
            int mid = low + (target - arr[low]) / (arr[height] - arr[low]) * (height - low);
            if (target == arr[mid]) {
                return mid;
            }
            if (target < arr[mid]) {
                height = mid;
            }
            if (target > arr[mid]) {
                low = mid;
            }
        }
        return -1;
    }


}
