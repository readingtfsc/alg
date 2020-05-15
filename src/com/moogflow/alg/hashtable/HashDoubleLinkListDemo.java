package com.moogflow.alg.hashtable;

import java.util.HashMap;

public class HashDoubleLinkListDemo {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.addFirst(new Node(1,"1"));
        int size = list.size();
        System.out.println(size);


        LRUCache cache = new LRUCache(3);
        cache.put(new Node(1,"1"));
        cache.put(new Node(2,"2"));
        cache.put(new Node(3,"3"));
        cache.put(new Node(4,"4"));
        cache.put(new Node(5,"5"));
        Node n = cache.get(5);
        System.out.println(n.key+n.value);
        Node n1 = cache.get(1);
        System.out.println(n1.key+n1.value);
    }
}

class Node {
    public int key;
    public String value;
    public Node next;
    public Node prev;

    public Node(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public Node() {
    }
}

class DoubleLinkedList {
    private Node head = new Node();

    // 在链表头部添加节点 x
    public void addFirst(Node x) {
        x.next = head.next;
        head.next = x;
    }

    // 删除链表中的 x 节点（x 一定存在）
    public void remove(Node x) {

        if (head.next == null) {
        }
        Node temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp.key == x.key) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag){
          //  temp.prev.next = temp.next;
            if (temp.next!=null){
                temp.next.prev = temp.prev;
            }
        }

    }

    // 删除链表中最后一个节点，并返回该节点
    public Node removeLast() {
        if (head.next == null) {
            return null;
        }
        Node temp = head.next;
        while (true) {
            if (temp.next == null) {
               Node t = temp;
                temp = null;
                return t;
            }
            temp = temp.next;
        }
    }

    private Node getLast() {

        if (head.next == null) {
            return null;
        }
        Node temp = head.next;
        while (true) {
            if (temp.next == null) {
                return temp;
            }
            temp = temp.next;
        }
    }


    // 返回链表长度
    public int size() {
        int size =0;
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
            size++;
        }
        return size;
    }
}

class LRUCache {
    private HashMap<Integer, Node> map;
    private DoubleLinkedList linkedList;
    private int cap;

    public LRUCache(int cap) {
        this.cap = cap;
        map = new HashMap<>();
        linkedList = new DoubleLinkedList();
    }

    public Node get(int key) {
        if (!map.containsKey(key)) {
            System.out.println("不存在..");
            return null;
        }
        Node node = map.get(key);

        // TODO 提到链表前面
        put(node);
        return node;
    }

    public void put(Node node) {
        if (map.containsKey(node.key)) {

            // 删除后重新加入到头结点
            linkedList.remove(node);
            linkedList.addFirst(node);
            // 更新 map 对应的数据
            map.put(node.key, node);
        } else {  // 不存在
            // 判断容量
            if (cap == linkedList.size()) {
                Node last = linkedList.removeLast();
                map.remove(last.key);
            }
            // 添加到头部
            linkedList.addFirst(node);
            // 更新map
            map.put(node.key, node);
        }

    }

}