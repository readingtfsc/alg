package com.moogflow.alg.fibonacci;


/**
 *  斐波那契数列
 *
 */
public class Fibonacci {
    public static void main(String[] args) {

        long[] sequence = fibonacciSequence(20);

        for (long l : sequence) {
            System.out.printf("%d\t", l);
        }
        System.out.println();


        int i = fiSeqRecursion(7);
        System.out.println(i);


        int i2 = fiSeqLoop(7);
        System.out.println(i2);


    }


    private static int fiSeqLoop(int n) {
        if (n < 1) {
            return -1;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[] temp = new int[n];
        temp[0] = 1;
        temp[1] = 1;

        for (int i = 2; i < n; i++) {
            temp[i] = temp[i - 1] + temp[i - 2];
        }
        return temp[n - 1];
    }

    private static int fiSeqRecursion(int n) {
        if (n < 1) {
            return -1;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        return fiSeqRecursion(n - 1) + fiSeqRecursion(n - 2);
    }

    /**
     * 生成斐波那契数列
     *
     * @param size
     * @return
     */
    private static long[] fibonacciSequence(int size) {
        if (size <= 0) {
            throw new RuntimeException("斐波那契数列大小 " + size + " 不合法");
        }
        long[] temp = new long[size];
        temp[0] = 1;
        temp[1] = 1;
        for (int i = 2; i < size; i++) {
            temp[i] = temp[i - 1] + temp[i - 2];
        }
        return temp;
    }

}
