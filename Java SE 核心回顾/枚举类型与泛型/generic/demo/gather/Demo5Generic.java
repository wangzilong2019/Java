package com.generic.demo.gather;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *   泛型通配符；
 *      ? 代表任意数据类型
 *    使用方式：
 *       不能创建对象使用
 *       不能作为方法参数使用
 *    可以使用泛型通配符来遍历任意数据类型集合
 * */
public class Demo5Generic {
    public static void main(String[] args) {
        //创建集合对象1
        ArrayList<String> list = new ArrayList<>();
        list.add("小王");
        list.add("小丽");

        //创建集合对象二
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);

        //遍历集合
        showArray(list);
        showArray(list2);
    }

    //定义一个方法，可以遍历任何数据类型集合
    public static void showArray(ArrayList<?> list ) {
        //使用迭代器遍历集合
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
             Object obj = it.next();
             System.out.println(obj);
        }
    }
}
