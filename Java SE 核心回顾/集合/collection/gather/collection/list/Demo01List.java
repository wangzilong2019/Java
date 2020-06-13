package com.gather.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 *   list接口继承了Collection接口，可在Collection基础之上添加一些新方法
 * */
public class Demo01List {
    public static void main(String[] args) {
        //使用多态创建集合对象
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        //遍历集合
        System.out.println(list);
        System.out.println("----------");

        //在指定索引位置添加元素
        list.add(1, "马龙");
        System.out.println(list);
        System.out.println("----------");

        //更改指定索引位置元素
        String setStr = list.set(0, "刘国梁");
        System.out.println(list);
        System.out.println("----------");

        //移出指定索引位置元素
        String removeEle = list.remove(3);
        System.out.println(list);
        System.out.println("----------");

        //list集合带有索引
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
