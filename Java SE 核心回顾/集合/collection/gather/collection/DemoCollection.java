package com.gather.collection;

import java.util.ArrayList;
import java.util.Collection;

public class DemoCollection {
    public static void main(String[] args) {
        /**
         *  Collection集合中一些常用方法的操作
         *    熟悉最顶层的集合，则了解下层则要简单多
         * */
        /**
         *   使用多态的好处，使之可以私用Collection集合方法操作
         *
         * */
        //使用多态创建一个集合对象
        Collection<String> col = new ArrayList<>();
        //1、向集合中添加元素
        col.add("小王");
        col.add("小丽");
        System.out.println(col);   //此时重写了toString()方法

        //2、判断集合中是否有某元素
        boolean flag1 = col.contains("小丽");
        System.out.println(flag1);

        //3、判断集合是否为空
        boolean flag2 = col.isEmpty();
        System.out.println(flag2);

        //4、从集合中删除某元素，并判断是否删除成功
        boolean flag3 = col.remove("小丽");

        //5、将集合变成数组输出
        System.out.println(col);

        //7、将集合转换为数组输出
        Object[] arr = col.toArray();
        for (Object obj : arr) {
            System.out.println(obj);
        }

        //6、清空集合所有元素
        col.clear();
        System.out.println(col);


    }
}
