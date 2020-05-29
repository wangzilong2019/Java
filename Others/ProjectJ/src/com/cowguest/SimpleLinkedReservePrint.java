package com.cowguest;

import java.util.ArrayList;

public class SimpleLinkedReservePrint {
    public static void main (String args[]) {

    }
}

class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        //定义一个指针指向链表中的第一个元素
        ListNode temp = listNode;
        //定义一个集合用来存放新生成的元素
        ArrayList<Integer> newList = new ArrayList<>();
        while (temp != null) {
            newList.add(0, temp.val);
            temp = temp.next;
        }
        return newList;
    }

    ArrayList<Integer> newList = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        //递归放啊解决
        if (listNode.next != null) {
            printListFromTailToHead2(listNode.next);
            //利用栈从后往前添加数据
            newList.add(listNode.val);
        }
        return newList;
    }
}

class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}