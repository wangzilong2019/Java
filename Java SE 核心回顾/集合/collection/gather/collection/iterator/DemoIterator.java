package com.gather.collection.iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *   迭代器：
 *      对Collection接口通用的遍历方法，所有实现该接口的类都可以使用
 *      目的：对集合进行遍历（因为Collection无索引）
 *   使用步骤：
 *      1、使用集合中的iterator()获取迭代器的实现类对象，使用Iterator接口接收（多态）
 *      2、使用Iterator接口中的hasNext()方法判断有无下一个元素
 *      3、使用Iterator接口中的next()方法取出下一个元素
 *
 * */

public class DemoIterator {
    public static void main(String[] args) {
        /**
         *  迭代器的使用
         * */
        /**
         * 1、使用集合中的iterator()获取迭代器的实现类对象，使用Iterator接口接收（多态）
         *    注意迭代器接口也是有泛型的，它的泛型跟则集合走
         * */
        //创建一个集合
        Collection<String> col = new ArrayList<>();
        col.add("马龙");
        col.add("张继科");
        col.add("樊振东");

        Iterator<String> it = col.iterator();
        //遍历集合
        while (it.hasNext()) {
            String e = it.next();
            System.out.println(e);
        }
    }
}
