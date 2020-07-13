package com.functioninterface.demo01.consumer;

import java.util.function.Consumer;

/**
 *   java.util.function.Consumer<T> 接口正好与Supplier接口相反
 *   他不是生产一个数据，而是消费一个数据，数据类型由泛型决定
 *   Consumer<T>接口是一个消费类型接口，泛型使用什么类型，就可以使用accept方法消费什么类型的数据
 *
 */
public class Demo01Consumer {
    /**
     *  定义一个方法
     *  方法的参数传递一个字符串姓名
     *  方法的参数传递Consumer接口泛型使用String
     *  可以使用Consumer接口消费字符串的姓名
     */
    public static void method(String name, Consumer<String> con) {
        con.accept(name);
    }

    public static void main(String[] args) {
        //调用method方法，方法的参数传递字符串姓名，另一个参数是一个Consumer接口 ，可以使用lambda表达式
        method("樊振东", (name)-> {
            //消费方式：直接输出字符串
            //System.out.println(name);

            //消费方式：对字符串进行反转
            String reName = new StringBuilder(name).reverse().toString();
            System.out.println(reName);
        });

    }
}
