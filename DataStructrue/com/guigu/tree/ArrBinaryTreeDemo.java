package com.guigu.tree;

public class ArrBinaryTreeDemo {
    public static void main (String args[]) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();
    }
}

//创建一个ArrBinaryTree实现顺序存储
class ArrBinaryTree{
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //重载preOder
    public void preOrder() {
        this.preOrder(0);
    }

    //实现顺序c存储二叉树的前序遍历
    public void preOrder(int index) {
        //如果数组为空或是 arr.leng = 0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        } else {
            //输出当前元素
            System.out.println(arr[index]);
            //向左递归遍历
            if ((2 * index + 1) < arr.length) {
                preOrder(2*index + 1);
            }
            //向右递归遍历
            if ((2 * index + 2) < arr.length) {
                preOrder(2*index + 2);
            }
        }
    }
}
