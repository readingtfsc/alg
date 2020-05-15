package com.moogflow.alg.tree.bitree;

public class ArrBiTreeDemo {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        ArrBiTree arrBiTree = new ArrBiTree<Integer>(arr);
        arrBiTree.preOrder();
        //1	2	4	8	5	3	6	7
    }
}

class ArrBiTree<T> {
    private T[] arr;

    public ArrBiTree(T[] arr) {
        this.arr = arr;
    }

    public void preOrder() {
        this.preOrder(0);
    }

    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("空数组..");
        }

        System.out.printf("%d\t", arr[index]);
        if (index * 2 + 1 < arr.length) {
            preOrder(index * 2 + 1);
        }
        if (index * 2 + 2 < arr.length) {
            preOrder(index * 2 + 2);
        }
    }


}