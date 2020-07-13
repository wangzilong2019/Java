package com.functioninterface.demo01.andthen;

import java.util.function.Function;

/**
 *   Function 接口中默认方法andThen
 *     作用：将分解的步骤连接在一起
 *     需求：把String类型123转换为Integer类型，将转换后的结果加10
 *     把增加后的 结果转换为Integer类型
 *     转化了俩次：
 *         第一次：Integer->String类型
 *         第二次：String->Integer类型
 */
public class Demo01AndThen {
    /**
     *   定义一个方法
     *     参数一个为字符串，另外俩个为接口
     */
    public static void change(String s, Function<String, Integer> fun1, Function<Integer, String> fun2) {
        //将字符串类型转换为Integer类型再转换为字符串类型
        String str = fun1.andThen(fun2).apply(s);
        System.out.println(str);
    }

    public static void main(String[] args) {
        //定义一个字符串类型整数
        String num = "123";
        //调用change方法，传递字符串和俩个lambda表达式
        change(num, (str)-> {
            //将字符串类型转换为整数类型再加上10
            return Integer.parseInt(str) + 10;
        }, (s)-> {
            return s+"";
        });
    }
}
