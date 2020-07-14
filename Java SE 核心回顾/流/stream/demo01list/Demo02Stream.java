package com.stream.demo01list;

import java.util.ArrayList;
import java.util.List;

/**
 *   使用Stream流的方式，对集合中的元素进行guolv
 *   Stream流是jdk1.8之后出现的
 *   不关注怎么做，而关注做什么
 */
public class Demo02Stream {
    public static void main(String[] args) {
        //创建一个集合存储姓名
        List<String> list = new ArrayList<>();
        list.add("马龙");
        list.add("樊振东");
        list.add("张继科");
        list.add("张三丰");

        //对list集合进行过滤，过滤张开头的姓名，存储到一个集合中
        //对新集合进行过滤，只要姓名长度为3的人，存储到一个新集合
        //遍历新集合
        //这里使用lambda表达式
        list.stream()
                .filter(name->name.startsWith("张"))
                .filter(name->name.length() == 3)
                .forEach(name-> System.out.println(name));
    }
}
