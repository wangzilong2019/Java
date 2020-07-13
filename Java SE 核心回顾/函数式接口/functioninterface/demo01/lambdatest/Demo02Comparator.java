package com.functioninterface.demo01.lambdatest;

import java.util.Arrays;
import java.util.Comparator;

/**
 *   如果函数的返回值类型是一个函数式接口那么就可以直接返回一个lambda表达式
 */
public class Demo02Comparator {
    /**
     *  定义一个函数，函数的返回值类型为函数式接口
     */
    public static Comparator<String> getComparator() {
//        return new Comparator<String>() {
//            @Override
//            public int compare(String s, String t1) {
//                return s.length() - t1.length();
//            }
//        }

        /**
         *   使用lambda表达式
         */
        return (s,t1)-> s.length()-t1.length();
    }

    public static void main(String[] args) {
        String[] arr = {"aaa", "aa", "lllll"};
        System.out.println(Arrays.toString(arr));
        //调用方法对字符串长度排序
        Arrays.sort(arr, getComparator());
        System.out.println(Arrays.toString(arr));

    }
}
