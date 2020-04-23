package com.guigu.tree;

public class BinaryTreeDemo {
    public static void main (String args[]) {
        //首先创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();

        //创建节点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");

        //手动创建二叉树
        binaryTree.setRoot(root);
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);

        System.out.println("前序遍历");
        binaryTree.preOrder();
    }
}

//创建二叉树
class BinaryTree{
    private HeroNode root;  //指针指向根节点

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder() {
        //当前根节点不为空时
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("当前二叉树为空");
        }
    }

    //中序遍历
    public void inFixOrder() {
        //当前根节点不为空时
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("当前二叉树为空");
        }
    }

    //后序遍历
    public void postOrder() {
        //当前根节点不为空时
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("当前二叉树为空");
        }
    }
}

//创建节点
class HeroNode{
    private int id;
    private String name;
    private HeroNode left; //指针指向左节点
    private HeroNode right; //指针指向右节点

    //节点构造器
    public HeroNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //前序遍历二叉树
    public void preOrder() {
        System.out.println(this);  //输出当前节点
        //左节点不为空
        if (left != null) {
            left.preOrder();
        }
        //右节点不为空
        if (right != null) {
            right.preOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        //左节点不为空
        if (this.left != null) {
            this.left.postOrder();
        }
        //右节点不为空
        if (this.right != null) {
            this.right.postOrder();
        }
        //输出当前根节点
        System.out.println(this);
    }

    //中序遍历
    public void inFixOrder() {
        //左节点不为空
        if (this.left != null) {
            this.left.inFixOrder();
        }
        //输入当前根节点
        System.out.println(this);
        //右节点不为空
        if (this.right != null) {
            this.right.inFixOrder();
        }
    }

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

    public void setLeft(HeroNode left) {
        this.left = left;
    }
    public HeroNode getLeft() {
        return left;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }
    public HeroNode getRight() {
        return right;
    }

    public String toString() {
        return "HeroNode [no=" + id + ", name=" + name + "]";
    }
}
