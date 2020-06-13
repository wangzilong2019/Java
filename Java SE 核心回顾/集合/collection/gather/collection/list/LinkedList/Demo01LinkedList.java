package com.gather.collection.list.LinkedList;

import com.sun.security.jgss.GSSUtil;

import java.util.LinkedList;

/**
 *   LinkedList 集合同样也是继承了List集合
 *     优点：因为底层使用链表实现，所以增删效率较高
 *     缺点：查询效率低
 *   注意：此实现不是同步的，即多线程
 *
 * */
public class Demo01LinkedList {
    public static void main(String[] args) {
        //创建一个LinkedList集合
        LinkedList<String> linked = new LinkedList<>();
        linked.add("a");
        linked.add("b");
        linked.add("c");
        linked.add("d");
        System.out.println(linked);
        System.out.println("-------------------");

        //向集合头添加元素
        linked.push("头部元素");
        linked.addFirst("头部元素2");
        System.out.println(linked);
        System.out.println("-------------------");

        //向集合尾部添加元素
        linked.addLast("尾部元素1");
        System.out.println(linked);
        System.out.println("--------------------");

        //获取头部元素
        String firstEle = linked.getFirst();
        System.out.println(firstEle);
        System.out.println("                    ");

        //获取尾部元素
        String lastEle = linked.getLast();
        System.out.println(lastEle);
        System.out.println("-------------------");

        //删除并返回头部元素
        String removeEle = linked.removeFirst();
        String pop = linked.pop();

        //删除并返回尾部元素
        String removeElel = linked.removeLast();

        System.out.println(linked);
    }
}
