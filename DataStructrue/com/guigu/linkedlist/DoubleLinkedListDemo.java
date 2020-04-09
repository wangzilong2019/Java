package com.guigu.linkedlist;

public class DoubleLinkedListDemo {
    public static void main (String args[]) {
        System.out.println("双向链表的测试");
        //创建节点
        HeroNode2 heroNode1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 heroNode2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 heroNode3 = new HeroNode2(3,"吴用", "智多星");
        HeroNode2 heroNode4 = new HeroNode2(4,"林冲", "豹子头");
        //创建双向链表对象
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        //双向链表添加节点
        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.add(heroNode4);
        //遍历双向链表
        doubleLinkedList.show();

        //修改
        HeroNode2 heroNode = new HeroNode2(4,"公孙胜", "入云龙");
        doubleLinkedList.upDate(heroNode);
        System.out.println("修改后的链表~~");
        doubleLinkedList.show();

        //删除
        doubleLinkedList.delete(3);
        System.out.println("删除节点后的链表为");
        doubleLinkedList.show();

        //按序号顺序添加
        HeroNode2 heroNode5 = new HeroNode2(3,"吴用", "智多星");
        doubleLinkedList.addByOrder(heroNode5);
        System.out.println("按顺序添加节点之后的链表为~~~");
        doubleLinkedList.show();
    }
}
//创建双向链表类
class DoubleLinkedList{
    //初始化一个头节点
    HeroNode2 head = new HeroNode2(0, "","");
    //饭返回头节点
    public HeroNode2 getHead() {
        return head;
    }
    //遍历链表
    public void show() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //定义临时指针指向第一个节点
        HeroNode2 temp = head.next;
        while (true) {
            System.out.println(temp);
            temp = temp.next;
            if (temp == null) {
                break;
            }
        }
    }
    //尾插法建立单链表
    public void add (HeroNode2 heroNode) {
        //首先定义一个指针指向头节点
        HeroNode2 temp = head;
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
        heroNode.pre = temp;
    }

    //按照节点编号顺序来添加节点，若节点编号村则，则题是，且不添加
    //而且要找到待插入位置的前一个节点
    public void addByOrder (HeroNode2 heroNode) {
        //首先定义一个临时指针指向头节点
        HeroNode2 temp = head;
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
            heroNode.next.pre = heroNode;
            temp.next = heroNode;
            heroNode.pre = temp;
        }
    }

    //根据编号修改节点信息
    public void upDate(HeroNode2 newHeroNode) {
        //首先判断链表是否为空
        if (head.next == null) {
            System.out.println("该链表为空，无法修改信息");
        }
        //定义一个临时指针指向链表节点，用来遍历链表
        HeroNode2 temp = head.next;
        //flag用来判断是否找到该编号
        boolean flag = false;
        while (true) {
            //到链表尾
            if (temp == null) {
                System.out.println("遍历完该链表，没有找到该编号节点编号");
                break;
            }
            //找到该接待你
            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到该节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        }else {
            System.out.printf("此链表中不存在编号为%d的节点\n", newHeroNode.no);
        }
    }
    //链表节点的删除：首先找到待删除节点的前一个节点，然乎后删除
    public void delete(int no) {
        //定义一个临时指针指向单链表中的节点
        HeroNode2 temp = head.next;
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("该链表为空");
            return;
        }
        //设标识符判断是否找到
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            //找到待删除节点的节点
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判断找到节点
        if (flag) {
            temp.pre.next = temp.next;
            //这里代码有问题，若是最后一个节点则不需要执行以下语句，否则会出现空指针异常
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        }else {
            System.out.printf("节点编号为%d的不存在\n",no);
        }
    }
}
//创建HeroNode类，每个heroNode代表一个节点
class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;  //指向下一个节点
    public HeroNode2 pre;  //指向前一个节点
    //创建节点构造器
    public HeroNode2(int no, String name, String nickName) {
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
