package com.moogflow.alg.tree.bitree;

public class LinkedListBiTreeDemo {
    public static void main(String[] args) {

    }
}

class LinkedListBiTree<T> {

    // 根节点
    private LinkedListNode<T> root;

}


class LinkedListNode<T> {
    private T data;

    private T leftNode;
    private T rightNode;


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(T leftNode) {
        this.leftNode = leftNode;
    }

    public T getRightNode() {
        return rightNode;
    }

    public void setRightNode(T rightNode) {
        this.rightNode = rightNode;
    }

    public LinkedListNode(T data) {
        this.data = data;
    }

    public LinkedListNode(T data, T leftNode, T rightNode) {
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
}