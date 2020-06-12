package com.generic.demo.gather;

import javafx.collections.ArrayChangeListener;

import java.util.ArrayList;
import java.util.Iterator;

public class DemoGather {
    public static void main(String[] args) {
        show1();
    }

    /**
     *   创建集合使用泛型
     *   好处：
     *       避免了类型转换的麻烦，存储的是什么类型，取出的就是什么类型
     *       把运行期异常提升到了编译器异常
     *    弊端：
     *       泛型是什么类型，只能存储什么类型
     */

    /**
     *
     *  创建集合使用泛型
     *     好处：集合不适用泛型，默认类型为Object类型，可以存储任意类型
     *     弊端：造成集合不安全，容易引发异常
     */

    public static void show1() {
        ArrayList list = new ArrayList();
        list.add("小狗");
        list.add(1);

        //使用迭代器遍历集合
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            System.out.println(obj);
        }
    }
}
