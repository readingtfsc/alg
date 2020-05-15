package com.moogflow.alg.linkedlist;


import java.util.Random;

public class SkipListDemo {
    public static void main(String[] args) {

    }
}

class SkipList<T> {
    // 跳跃表的层数
    public int level;
    // 跳跃表的节点个数
    public int length;
    // 头结点
    public SkipNode<T> head;
    public SkipNode<T> tail;

    public Random random; // 随机


}

class SkipNode<T> {
    public T node;
    public T up;
    public T down;
    public T left;
    public T right;

    public SkipNode(T node){
        this.node = node;
    }


}