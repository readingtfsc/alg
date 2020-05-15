package com.moogflow.alg.hashtable;

public class HashTableDemo {
    public static void main(String[] args) {
    }
}

class HashTable {

    // 数组存放元素
    public elementLinkList[] list;
    //链表数量
    public int size;

    private HashTable() {
        this.size = 7;
        this.list = new elementLinkList[7];
    }

    public int hash(int id) {
        return id % this.size;
    }


    void add(Emp emp) {
        int no = hashFun(emp.id);
        this.list[no].add(emp);
    }


    public int hashFun(int id) {
        return id % this.size;
    }
}

class elementLinkList {
    public Emp head;

    boolean add(Emp element) {
        // 如果是第一位元素
        if (head == null) {
            head = element;
            return true;
        }
        // 如果不是第一位元素
        Emp curElement = head;
        while (true) {
            if (curElement.next == null) {
                break;
            }
            // 后移
            curElement = curElement.next;
        }
        curElement.next = element;
        return true;
    }

    void list() {

    }
}


class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}