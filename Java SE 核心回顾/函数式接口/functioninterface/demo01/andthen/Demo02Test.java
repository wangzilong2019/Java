package com.functioninterface.demo01.andthen;

import java.util.function.Function;

/**
 *   练习：自定义函数拼接模型
 *   String str = "赵丽颖,20";
 *   分析：
 *      1、截取字符串年龄部分
 *      2、将字符串类型转换为Integer类型
 *      3、将上一步的int数字累加100
 */
public class Demo02Test {
    /**
     *   定义i一个方法：
     *     参数传递一个字符串，三个接口
     */
    public static void change(String s, Function<String, String> fun1, Function<String, Integer> fun2, Function<Integer, Integer> fun3) {
        //把三个组合到yiqi
        int ans = fun1.andThen(fun2).andThen(fun3).apply(s);
        System.out.println(ans);
    }

    public static void main(String[] args) {
        //定义一个字符串
        String s = "赵丽颖,20";
        //调用change方法，长短地一个字符串，三个接口
        change(s, (str)-> {
            //截取年龄部分
            String age = str.split(",")[1];
            return age;
        }, (str2)-> {
            //将字符串类型转换为int类型
            return Integer.parseInt(str2);
        }, (num)-> {
            //将结果加上100
            return num+100;
        });
    }
}
