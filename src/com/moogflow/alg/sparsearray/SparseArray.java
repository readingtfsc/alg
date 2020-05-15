package com.moogflow.alg.sparsearray;


/**
 * 稀疏数组
 */


public class SparseArray {
    public static void main(String[] args) {
        int[][] arr = new int[11][11];
        arr[1][2] = 1;
        arr[2][3] = 2;
        arr[3][4] = 2;
        int[][] SparseArr = Arr2SparseArr(arr);
        SparseArr2Arr(SparseArr);

    }

    public static int[][] Arr2SparseArr(int[][] arr) {

        int sum = 0;
        for (int[] is : arr) {
            for (int i : is) {
                if (i != 0) {
                    sum++;
                }
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }

        int sparseArr[][] = new int[sum + 1][3];
        sparseArr[0][0] = arr.length;
        sparseArr[0][1] = arr[0].length;
        sparseArr[0][2] = sum;


        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = arr[i][j];
                }
            }
        }

        for (int[] is : sparseArr) {
            for (int i : is) {
                if (i != 0) {
                    sum++;
                }
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }

        return sparseArr;
    }

    public static int[][] SparseArr2Arr(int[][] sparseAll) {
        int i = sparseAll[0][0];
        int j = sparseAll[0][1];
        int[][] arr = new int[i][j];

        for (int k = 1; k < sparseAll.length; k++) {
            arr[sparseAll[k][0]][sparseAll[k][1]] = sparseAll[k][2];
        }

        System.out.println("==================================");
        for (int[] is : arr) {
            for (int s : is) {
                System.out.printf("%d\t", s);
            }
            System.out.println();
        }
        return arr;
    }
}
