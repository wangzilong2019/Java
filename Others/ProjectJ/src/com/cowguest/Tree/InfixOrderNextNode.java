package com.cowguest.Tree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;

public class InfixOrderNextNode {

}

class Solution1 {
    /**
     * 题目要求，打印中序遍历二叉树的下一个节点
     *  思路1：先将二叉树打印出来存放在一个集合中，然后再找到下一个节点
     * */
    static ArrayList<TreeLinkNode> list = new ArrayList<>();
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        //先找打根节点
        TreeLinkNode root = pNode;
        while (root.next != null) {
            root = root.next;
        }
        //中序遍历二叉树
        infixOrder(root);
        //遍历集合找到带查找节点的下一个节点
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == pNode) {
                return i == list.size() - 1 ? null : list.get(i + 1);
            }
        }
        return null;
    }

    //中序打印二叉树
    public void infixOrder(TreeLinkNode root) {
        if (root != null) {
            infixOrder(root.left);
            list.add(root);
            infixOrder(root.right);
        }
    }

    /**
     *   思路二：
     *     由于有指针指向父节点，可以此来简便查找加入查找 node 的下一个节点
     *     1、若node的右子树不为空，则下一个节点为node节点的右子树的最左节点
     *     2、若node的右子树为空
     *        1、若node节点的右子树为空且node节点为它的父节点的左节点，则下一个节点为node的父节点
     *        2、若node节点的右子树为空且node节点为它的父节点的右节点，一直沿着父节点追朔，直到找到某个节点为它的父节点的左子树
     *
     * */
    public TreeLinkNode GetNext2(TreeLinkNode pNode) {
        //当此节点的右子树不为空时
        if (pNode.right != null) {
            TreeLinkNode pRight = pNode.right;
            //找到pRight为根节点的树的最左节点
            while (pRight.left != null) {
                pRight = pRight.left;
            }
            return pRight;
        }

        //当pNode节点的右子树为空时
        //当pNode为它的父节点的左子树时
        if (pNode.next != null && pNode.next.left == pNode) {
            return pNode.next;
        }

        //当pNode为它的父节点的右子树时
        if (pNode.next != null) {
            TreeLinkNode pNext = pNode.next;
            //找打某个节点的某它的父节点左子树
            while (pNext.next != null && pNext.next.right == pNext) {
                pNext = pNext.next;
            }
            return pNext.next;
        }
        return null;
    }

}

class TreeLinkNode {
    int val;
    TreeLinkNode left =null;
    TreeLinkNode right = null;
    TreeLinkNode next = null; //指向父节点

    public TreeLinkNode (int val) {
        this.val = val;
    }
}

