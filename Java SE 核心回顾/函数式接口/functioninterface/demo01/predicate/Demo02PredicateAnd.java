package com.functioninterface.demo01.predicate;

import java.util.function.Predicate;

/**
 *    逻辑表达式，可以连接多个判断条件
 *    && || ！
 *    需求：判断一个字符串，有俩个判断条件
 *          1、判断字符串长度是否大于5
 *          2、判断字符串中是否包含a
 *
 */
public class Demo02PredicateAnd {
    /**
     *   定义一个方法，转递一个字符串，俩个接口
     *      一个接口判断一个条件
     */
    public static boolean checkString(String s, Predicate<String> pre1, Predicate<String> pre2) {
        //return pre1.test(s) && pre2.test(s);
        return pre1.and(pre2).test(s);

        /**
         *  若是或 return pre1.or(pre2).test(s);
         */
        /**
         *  对结果取反 return pre.negate().test(s);
         */
    }

    public static void main(String[] args) {
        String s = "abcdfr";

        boolean ans = checkString(s, (str)->{
            //判断字符串长度是否大于5
            return str.length() > 5;
        }, (str)-> {
            //判断是否包含a
            return str.contains("a");
        });
        System.out.println(ans);
    }
}
