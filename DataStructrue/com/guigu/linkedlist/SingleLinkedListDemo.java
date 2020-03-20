package com.guigu.linkedlist;

public class SingleLinkedListDemo {
    public static void main (String args[]) {
        //创建节点
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3,"吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4,"林冲", "豹子头");
        //创建链表
        SingleLinkedList singleLinkedList= new SingleLinkedList();
//        singleLinkedList.add(heroNode1);
//        singleLinkedList.add(heroNode2);
//        singleLinkedList.add(heroNode3);
//        singleLinkedList.add(heroNode4);
        //按照编号顺序添加
          singleLinkedList.addByOrder(heroNode1);
          singleLinkedList.addByOrder(heroNode4);
          singleLinkedList.addByOrder(heroNode3);
          singleLinkedList.addByOrder(heroNode2);

        //遍历链表
        singleLinkedList.show();
    }
}
//定义SingleLinkedList来管理节点
class SingleLinkedList {
    //初始化一个头节点
    HeroNode head = new HeroNode(0, "","");
    //尾插法建立单链表
    public void add (HeroNode heroNode) {
        //首先定义一个指针指向头节点
        HeroNode temp = head;
        //首先找到链表的尾节点，然后插入
        while (true) {
            //找到尾节点
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        //将节点插入尾部
        temp.next = heroNode;
    }
    //按照节点编号顺序来添加节点，若节点编号村则，则题是，且不添加
    //而且要找到待插入位置的前一个节点
    public void addByOrder (HeroNode heroNode) {
        //首先定义一个临时指针指向头节点
        HeroNode temp = head;
        //定义标志变量来确定是否有插入相同编号节点
        boolean flag = false;
        while (true) {
            //判断是否到链表尾部
            if (temp.next == null) {
                break;
            } else {
                if (temp.next.no > heroNode.no) {
                    break;
                } else {
                    if (temp.next.no == heroNode.no) {
                        flag = true;
                        break;
                    }
                }
            }
            //遍历链表
            temp = temp.next;
        }
        //判断是否有编号相同的节点
        if (flag) {
            System.out.println("有编号相同的节点，无法添加");
        }
        else {
            //找到temp为待插入节点的前一个位置,且插入
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //遍历链表
    public void show() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //定义临时指针指向第一个节点
        HeroNode temp = head.next;
        while (true) {
            System.out.println(temp);
            temp = temp.next;
            if (temp == null) {
                break;
            }
        }
    }
}

//创建HeroNode类，每个heroNode代表一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;
    //创建节点构造器
    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }
    //为了显示方便，重新写toString方法

    @Override
    public String toString() {
        return "HeroNode[no = "+ no +", name = "+ name +", nickName = "+ nickName +"]";
    }
}
