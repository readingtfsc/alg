package com.moogflow.alg.search;

public class FibonacciSearch {


    //斐波那契数列大小
    private static final int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9,};
        int i = new FibonacciSearch().fibonacciSearchLoop(arr, 100);
        System.out.println(arr[i]);
    }

    public int fibonacciSearchLoop(int[] arr, int target) {


        int left = 0;
        int right = arr.length - 1;
        //黄金分割点（斐波那契分割点）下标
        int mid = 0;
        //第一个大于数组长度的斐波那契下标
        int k = 0;
        //获取斐波那契数列
        int[] fibSeq = fibonacciSequence(maxSize);
        //找到第一个大于数组长度的斐波那契下标:  神奇的汉字读不懂
        //这里的f[k]是arr距离斐波那契数列最近的数值，为什么-1，为了符合数组特性(数组最大元素下标是数组长度-1)

        // 他 要求表中的记录数 比 某个裴波那契数 小1
        while (arr.length > fibSeq[k] - 1) {
            k++;
        }

        while (left < right) {

            mid = left + fibSeq[k - 1] - 1;
            if (target == arr[mid]) {  //找到 直接返回
                return mid;
            }
            if (target < arr[mid]) {  // 向左查找，继续黄金分割
                // 查找前半部分，高位指针移动
                right = mid - 1;
                // f[k] = f[k-1] + f[k-1]
                // 因为前半部分有f[k-1]个元素，所以 k = k-1
                k = k - 1;
            }
            if (target > arr[mid]) {// 向有查找
                // 查找后半部分，低位指针移动
                left = mid + 1;
                // （全部元素） = （前半部分）+（后半部分）
                // f[k] = f[k-1] + f[k-1]
                // 因为后半部分有f[k-1]个元素，所以 k = k-2
                k = k - 2;
            }
        }
        return -1;
    }


    /**
     * 获取斐波那契数列
     *
     * @param size 斐波那契数列大小
     * @return
     */
    private static int[] fibonacciSequence(int size) {
        if (size <= 0) {
            throw new RuntimeException("斐波那契数列大小 " + size + " 不合法");
        }
        int[] temp = new int[size];
        temp[0] = 1;
        temp[1] = 1;
        for (int i = 2; i < size; i++) {
            temp[i] = temp[i - 1] + temp[i - 2];
        }
        return temp;
    }

}
