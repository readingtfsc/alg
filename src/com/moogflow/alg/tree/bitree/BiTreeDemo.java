package com.moogflow.alg.tree.bitree;

public class BiTreeDemo {
    public static void main(String[] args) {


        BiTree biTree = new BiTree();
        Node zs = new Node(1, "张三");
        Node ls = new Node(2, "李四");
        Node ww = new Node(3, "王五");
        Node zl = new Node(4, "赵六");
        Node wlq = new Node(5, "王老七");
        Node zlb = new Node(6, "赵老八");
        Node sjj = new Node(7, "孙老九");

        biTree.setRoot(zs);
        zs.setLeft(ls);
        zs.setRight(ww);
        ls.setRight(zl);
        ls.setLeft(wlq);

        biTree.preOrder();

        System.out.println("----");
        biTree.delNodeUninvolvedChildren(2);
        biTree.preOrder();


        System.out.println("----");
        biTree.delNode(2);
        biTree.preOrder();


    }
}


/**
 * 二叉树
 */
class BiTree {
    //根节点
    private Node root;

    // 设置根节点
    public void setRoot(Node root) {
        this.root = root;
    }

    // 删除节点
    public void delNode(int id) {
        if (root != null) {
            if (root.getId() == id) {
                root = null;
            } else {
                root.delNode(id);
            }
        } else {
            System.out.println("空树..");
        }
    }

    //     删除节点
    //     如果仅有一个子节点 保留子节点
    //     如果有两个子节点 保留左子节点
    public void delNodeUninvolvedChildren(int id) {
        if (root != null) {
            if (root.getId() == id) {
                // 判断左子节点
                if (root.getLeft() != null) {
                    root = root.getLeft();
                }
                //判断右子节点
                if (root.getRight() != null) {
                    if (root.getLeft() != null) {
                        root = root.getLeft();
                    } else {
                        root = root.getRight();
                    }
                }
            } else {
                root.delNodeUninvolvedChildren(id);
            }
        } else {
            System.out.println("空树..");
        }
    }

    // 前序遍历
    public void preOrder() {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("空树..");
        }
    }

    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("空树..");
        }
    }

    public void postOrder() {
        if (root != null) {
            root.postOrder();
        } else {
            System.out.println("空树..");
        }
    }
}


/**
 * 节点类
 */

class Node {
    private int id;
    private String name;

    // 左子节点 默认为null
    private Node left;

    // 右子节点 默认为null
    private Node right;

    //构造函数
    public Node(int id, String name) {
        this.id = id;
        this.name = name;
        this.left = null;
        this.right = null;
    }


    /**
     * 删除节点 不删除掉子树
     * <p>
     * 如果仅有一个子节点 保留子节点
     * 如果有两个子节点 保留左子节点
     */
    public void delNodeUninvolvedChildren(int id) {
        // 判断左子节点
        if (this.left != null && this.left.id == id) {

            if (this.left.left != null) {
                this.left = this.left.left;
            }
            if (this.left.right != null) {

                if (this.left.right != null) {
                    this.left = this.left.left;
                } else {
                    this.left = this.left.right;
                }

            }
            return;
        }


        // 判断左子节点
        if (this.right != null && this.right.id == id) {

            if (this.right.left != null) {
                this.right = this.right.left;
            }
            if (this.right.right != null) {

                if (this.right.right != null) {
                    this.right = this.right.left;
                } else {
                    this.right = this.right.right;
                }
            }
            return;
        }


        // 向左子树进行递归
        if (this.left != null) {
            this.left.delNodeUninvolvedChildren(id);
        }
        // 向左子树进行递归
        if (this.right != null) {
            this.right.delNodeUninvolvedChildren(id);
        }

    }


    // 删除节点 删除掉子树
    public void delNode(int id) {
        // 判断左子节点
        if (this.left != null && this.left.id == id) {
            this.left = null;
            return;
        }

        // 判断右子节点
        if (this.right != null && this.right.id == id) {
            this.right = null;
            return;
        }

        // 向左子树进行递归
        if (this.left != null) {
            this.left.delNode(id);
        }
        // 向左子树进行递归
        if (this.right != null) {
            this.right.delNode(id);
        }
    }


    /**
     * 二叉树的三种遍历方式的查找
     */
    // 前序遍历
    public Node preOrderSearch(int id) {
        System.out.println("进入前序遍历查找..");

        // 比较当前节点
        if (this.id == id) {
            return this;
        }
        Node result = null;
        if (this.left != null) {
            result = this.left.preOrderSearch(id);
        }
        if (result != null) {  // 说明从左子节点中找到了
            return result;
        }
        if (this.right != null) {
            result = this.right.preOrderSearch(id);
        }
        return result;
    }

    // 后序遍历
    public Node postOrderSearch(int id) {
        Node result = null;
        if (this.left != null) {
            result = this.left.postOrderSearch(id);
        }
        if (result != null) {  // 说明从左子节点中找到了
            return result;
        }
        if (this.right != null) {
            result = this.right.postOrderSearch(id);
        }
        if (result != null) {  // 说明从右子节点中找到了
            return result;
        }
        if (this.id == id) {
            return this;
        }
        return result;
    }

    // 中序遍历
    public Node infixOrderSearch(int id) {
        Node result = null;
        if (this.left != null) {
            result = this.left.infixOrderSearch(id);
        }
        if (result != null) {  // 说明从左子节点中找到了
            return result;
        }
        if (this.id == id) {
            return this;
        }

        if (this.right != null) {
            result = this.right.infixOrderSearch(id);
        }
        return result;

    }


    /**
     * 二叉树的三种遍历方式
     */

    // 前序遍历
    public void preOrder() {

        //先输出当前节点
        System.out.println(this);

        //然后递归输出左子节点
        if (this.left != null) {
            this.left.preOrder();
        }
        //最后递归输出右子节点
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    // 后续遍历
    public void postOrder() {

        //最先递归输出左子节点
        if (this.left != null) {
            this.left.postOrder();
        }
        //然后递归输出右子节点
        if (this.right != null) {
            this.right.postOrder();
        }
        //最后输出当前节点
        System.out.println(this);
    }

    // 中序遍历
    public void infixOrder() {

        //最先递归输出左子节点
        if (this.left != null) {
            this.left.infixOrder();
        }

        //然后输出当前节点
        System.out.println(this);

        //最后递归输出右子节点
        if (this.right != null) {
            this.right.infixOrder();
        }

    }

    // toString
    @Override
    public String toString() {
        return "Node [id = " + id + "name: " + name + "]";
    }

    // getter / setter 方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }


}