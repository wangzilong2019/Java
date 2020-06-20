package com.varargs;

import java.util.Collections;

/**
 *   可变参数
 *       可变参数是在jdk1.5之后出现的新特性
 *       使用前提：当传递给方法的参数数据类型确定，但是参数的个数不确定时使用
 *    原理：
 *        可变参数底层是一个数组，根据参数的个数不同，会创建不同长度的数组，来存储这些参数
 *        传递到参数可以时0个或多个
 *    注意：
 *        1、一个方法的参数列表只能有一个可变参数
 *        2、如果方法参数有多个，可变参数必须写在最后
 * */
public class Demo01VarArgs {

    public static void main(String[] args) {
        int sum = add(1, 3, 4);
        System.out.println(sum);
    }

    /**
     *   给定位置数字个数求和
     * */
    public static int add(int...arr) {
        int sum = 0;
        System.out.println(arr);  //打印数组首地址
        System.out.println(arr.length);  //打印数组长度（参数个数）
        for (int e : arr) {
            sum += e;
        }
        return sum;
    }

    /**
     *
     *   可变参数最终级别写法
     * */
    public static void add3(Object...arr) {

    }
}
