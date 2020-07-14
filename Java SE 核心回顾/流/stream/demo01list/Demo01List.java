package com.stream.demo01list;

import java.util.ArrayList;
import java.util.List;

/**
 *   使用传统的方式，遍历集合，对集合中的元素进行过滤
 */
public class Demo01List {
    public static void main(String[] args) {
        //创建一个集合存储姓名
        List<String> list = new ArrayList<>();
        list.add("马龙");
        list.add("樊振东");
        list.add("张继科");
        list.add("张三丰");

        List<String> list1 = new ArrayList<>();
        //对集合中的张性元组过滤
        for (String name : list) {
            if (name.startsWith("张")) {
                list1.add(name);
            }
        }

        System.out.println(list1);
    }
}
