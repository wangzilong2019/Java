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

          //修改链表信息
        HeroNode newHeroNode = new HeroNode(2, "小波", "矮宁波");
        singleLinkedList.upDate(newHeroNode);

        //删除1号节点
        singleLinkedList.delete(2);

        //遍历链表
        singleLinkedList.show();

        //求单链表中节点个数
        int len = singleLinkedList.getLength(singleLinkedList.getHead());
        System.out.println("单链表中节点个数为：" + len);

        //找到倒数第index个节点
        HeroNode res = singleLinkedList.findLastIndexNode(singleLinkedList.getHead(),1);
        System.out.printf("HeroNode = " + res);
    }
}
//定义SingleLinkedList来管理节点
class SingleLinkedList {
    //初始化一个头节点
    HeroNode head = new HeroNode(0, "","");

    //饭返回头节点
    public HeroNode getHead() {
        return head;
    }

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

    //根据编号修改节点信息
    public void upDate(HeroNode newHeroNode) {
        //首先判断链表是否为空
        if (head.next == null) {
            System.out.println("该链表为空，无法修改信息");
        }
        //定义一个临时指针指向链表节点，用来遍历链表
        HeroNode temp = head.next;
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
        HeroNode temp = head;
        //设标识符判断是否找到
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            //找到待删除节点的前一个节点
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判断找到节点
        if (flag) {
            temp.next = temp.next.next;
        }else {
            System.out.printf("节点编号为%d的不存在\n",no);
        }
    }

    /**   求单链表中有效节点的个数（若带头节点则不算头节点）
     * */
    public static int getLength(HeroNode heroNode) {
        //判断链表是否为空
        if (heroNode.next == null) {
            return 0;
        }
        int length = 0;
        //定义一个临时指针指向链表节点
        HeroNode cur = heroNode.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    /**  1、首先编写一个方法，用来接收HeroNode和index
     *   2、获取单链表的长度length
     *   3、遍历length-index个节点
     *   4、返回该该节点
     *
     * */
    //找到倒数第index个节点
    public static HeroNode findLastIndexNode (HeroNode heroNode, int index) {
        //首先判断单链表是否为空
        if (heroNode.next == null) {
            return null;
        }
        //获取单链表的长度
        int size = getLength(heroNode);
        //判断index是否合法
        if (index <= 0 || index > size) {
            return null;
        }
        //定义一个临时指针遍历链表（for循环遍历size-index次）
        HeroNode cur = heroNode.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
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
