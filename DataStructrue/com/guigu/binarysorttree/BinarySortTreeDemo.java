package com.guigu.binarysorttree;

public class BinarySortTreeDemo {
    public static void main (String args[]) {

        //测试
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        BinarySortTree binarySortTree = new BinarySortTree();
        //创建一颗二叉排序树
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
        //中序遍历输出
        System.out.println("中序输出二叉树");
        binarySortTree.inFixOrder();

    }
}


//创建二叉排序树
class BinarySortTree{
    private Node root;

    //添加节点创建二叉排序树
    public void add(Node node) {
        //当前树为空树直接指向根节点
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    //中序遍历
    public void inFixOrder() {
        //当前树不为空树是遍历
        if (root != null) {
            root.inFixOrder();
        } else {
            System.out.println("当前树为空树");
        }
    }
}

//创建节点
class Node{
    int value;
    Node left;
    Node right;

    //节点构造器
    public Node(int value) {
        this.value = value;
    }

    //通过递归添加节点
    public void add(Node node) {
        //递归终止条件
        if (node == null) {
            return;
        }

        //判断传入的节点的权值和当前节点的大小
        if (node.value < this.value) {
            //判断当前节点左子树是否为空
            if (this.left == null) {
                this.left = node;
            } else {
                //否则递归添加
                this.left.add(node);
            }
        } else {
            //判断当前节点右子树是否为空
            if (this.right == null) {
                this.right = node;
            } else {
                //否则递归添加
                this.right.add(node);
            }
        }
    }

    //中序遍历排序树
    public void inFixOrder() {
        //当前节点左子树非空
        if (this.left != null) {
            this.left.inFixOrder();
        }
        //输出当前节点
        System.out.println(this);
        //输出当前节点又节点
        if (this.right != null) {
            this.right.inFixOrder();
        }
    }

    /**
     *  删除叶子节点
     *    1、首先找到待删除的节点targetNode
     *    2、找到targetNode节点的父节点 parent
     *    3、确定 targetNode是 parent的左子节点还是右子节点
     *    4、 左子节点 parent.left = null;
     *        右子节点 parent.right = null;
     * */

    /**
     *  删除只有一颗子树的节点
     *    1、手先找到待删除节点 targetNode
     *    2、找到targetNode节点的父节点parent
     *    3、且确定targetNode的节点是左子节点还是右子节点
     *    4、targetNode是parent的左子节点还是右子节点
     *    5、若targetNode有左子节点
     *       5.1 targetNode是parent的左节点
     *       parent.left = targetNode.left;
     *       5.2targetNode是parent的右子节点
     *       parent.right = targetNode.left;
     *    6、若targetNode有右子节点
     *       6.1 targetNode 是parent的左节点
     *       parent.left = target.right;
     *       6.2 targetNode 是 parent的右节点
     *       parent.right = target.right;
     *
     *
     * */

    /**
     *
     * */

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
