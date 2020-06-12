package com.generic.demo.gather;

/**
 * 定义泛型的方法
 *    在调用方法时确定泛型的数据类型
 *    传递什么类型的参数，泛型就是什么数据类型
 * */
public class GenericMethod {
    //定义一个含有泛型的方法
    public <E> void method(E e) {
        System.out.println(e);
    }

    //定义一个含有泛型的静态方法
    public static <S> void method2(S s) {
        System.out.println(s);
    }
}
