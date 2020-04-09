package com.guigu.linkedlist;

public class josepfu {
    public static void main (String args[]) {
        //测试
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        //添加节点
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();

        //测试约瑟夫环
        circleSingleLinkedList.countBoy(1,2,5);
    }
}

//创建单向循环链表
class CircleSingleLinkedList{
    //创建一个指针指向第一个节点
    private Boy first = null;
    //创建单向循环链表
    public void addBoy (int nums) {
        if (nums < 1) {
            System.out.println("输入nums值不正确");
            return;
        }
        //定义辅助指针构建单向循环链表
        Boy curBoy = null;
        //使用循环构建单向循环链表
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            //第一个节点构造时特殊
            if (i == 1 ) {
                first = boy;
                first.setNext(first);  //构成环
                curBoy = boy;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //遍历当前唤醒链表
    public void showBoy() {
        //判断链表是否为空
        if (first == null) {
            System.out.println("当前链表为空！");
            return;
        }
        //设置辅助指针
        Boy curBoy = first;
        while (true) {
            System.out.println("当前节点编号为：" + curBoy.getNo());
            //当遍历到最后一个节点时结束
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    //解决约瑟夫环问题
    public void countBoy(int startNo, int countNum, int nums) {
        //判断输入数据是否合法
        if (first == null || countNum < 1 || countNum > nums) {
            System.out.println("输入数据不合法");
            return;
        }
        //创建辅助变量完成节点的输出
        Boy helper = first;
        //先让helper指向最后一个节点
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数前，先让first和helper移动k-1次
        for (int i = 0; i < startNo-1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        while (true) {
            //报数前先让first和helper指向之后一个节点
            if (helper == first) {
                break;
            }
            //让first和helper指针同时移动countNum-1次
            for (int i = 0; i < countNum-1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时first指向的节点，是要出列的节点
            System.out.printf("小孩%d出圈\n", first.getNo());
            //这时first指向的节点出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号为：%d\n", first.getNo());

    }
}

//创建节点类 每个
class Boy {
    private int no;  //节点编号
    private Boy next;  //指向下一个节点
    //节点的构造方法
    public Boy (int no) {
        this.no = no;
    }
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }
    public void setNext(Boy next) {
        this.next = next;
    }
}
