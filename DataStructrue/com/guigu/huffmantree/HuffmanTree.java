package com.guigu.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public static void main (String args[]) {
        int[] arr = {5, 8, 3, 9, 0};
        Node root = huffmanTree(arr);
        preOrder(root);
    }

    //前序遍历二叉树
    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("该二叉树为空");
        }
    }

    //创建哈夫曼树
    /**
     *  1、遍历数组中的元素
     *  2、将每个元素构成一个Node
     *  3、将Node放入到ArrayLIstanbul中
     * */
    public static Node huffmanTree(int[] arr) {
        //创建数组集合存放节点
        List<Node> list = new ArrayList<Node>();
        //将数组元素构成节点,且将节点加入集合中
        for (int x : arr) {
            list.add(new Node(x));
        }

        //对节点中权值进行排序
        Collections.sort(list);
        //System.out.println(list);

        //构造哈夫曼树，集合中只有一个节点时说明已经构造完成
        //此节点为哈夫曼树的根节点
        while (list.size() > 1) {
            //取出最小权值的俩个节点
            Node left = list.get(0);
            Node right = list.get(1);

            //构造一颗哈夫曼树
            Node parent = new Node(left.value + right.value);
            parent.left = left;
            parent.right = right;

            //将根节点加入集合，俩个字节点删除
            list.add(parent);
            list.remove(left);
            list.remove(right);

            //对其中的节点权值排序
            Collections.sort(list);
        }

        //返回哈夫曼树的根节点
        return list.get(0);
    }
}

//构造节点
class Node implements Comparable<Node> {
    int value;  //节点权值
    Node left;  //指向左节点
    Node right; //指向右节点

    //节点构造器
    public Node(int value) {
        this.value = value;
    }

    //前序遍历二叉树
    public void preOrder() {
        //输出当前节点
        System.out.println(this);
        //输出左子树
        if (this.left != null) {
            this.left.preOrder();
        }
        //输出右子树
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //方法重载
    public String toString() {
        return "Node [value = " + value + "]";
    }
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}
