package com.moogflow.alg.tree.bst;


// 二叉查找树 BTS
// 要求 节点的左子节点小于当前节点 右子节点大于当前节点
public class BiSearchTreeDemo {
}

class BiSearchTree {

}

class BiSearchNode {
    private int id;
    private String name;

    // 左子节点 默认为null
    private BiSearchNode left;

    // 右子节点 默认为null
    private BiSearchNode right;

    public BiSearchNode(int id, String name) {
        this.id = id;
        this.name = name;
    }


    // 查找要删除的节点
    public BiSearchNode Search(int id) {

        if (this.id == id) {
            return this;
        }
        if (this.id < id) {
            if (this.right == null) {
                return null;
            }
            return this.right.Search(id);
        } else {
            if (this.left == null) {
                return null;
            }
            return this.left.Search(id);
        }
    }

}