package com.gather.collection.strongfor;

import java.util.ArrayList;
import java.util.stream.StreamSupport;

/**
 *   增强型for循环：
 *        底层使用的是迭代器原理，使用for循环格式，简化了迭代器的书写jdk1.5之后出现了
 *   注意：在以后遍历集合中常规使用增强型for循环遍历集合简化代码
 *       遍历对象只能为Collection或是数组
 * */
public class DemoStrongFor {
    public static void main(String[] args) {
        demo();
        demo2();
    }

    //使用增强型for循环遍历集合
    public static void demo2() {
        ArrayList<String> list = new ArrayList<>();
        list.add("小明");
        list.add("校长");
        list.add("过量");
        for (String str : list) {
            System.out.println(str);
        }
    }

    public static void demo() {
        int[] arr = {3, 2, 1, 5};
        for (int e : arr) {
            System.out.println(e);
        }
        //使用增强型for循环遍历集合
    }
}
