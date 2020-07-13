package com.functioninterface.demo01.function;

import java.util.function.Function;

/**
 *   java.util.function.Function<T,R>接口可以用来根据一个类型的数据的得到另一个类型的数据
 *     前者称为前置条件，后者称为后置条件
 *   Function接口最主要的抽象方法为：R apply<T t>  根据类型T的参数，获取R类型的结果
 *     使用场景：如将String类型转换为Integer类型
 */
public class Demo01Function {
    /**
     *  定义一个方法
     *     参数传递一个字符串类型整数
     *     方法的参数传递一个Function接口，泛型使用<String, Integer>
     *      使用Function接口中的方法apply，把字符串类型的整数转换为Integer类型
     */
    public static void change(String s, Function<String, Integer> fun) {
        Integer in = fun.apply(s);  //自动拆箱
        System.out.println(in);
    }

    public static void main(String[] args) {
        String s = "124";
        change(s, (str)-> {
            return Integer.parseInt(s);
        });
    }
}
