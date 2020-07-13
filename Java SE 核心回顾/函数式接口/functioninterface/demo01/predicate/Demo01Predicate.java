package com.functioninterface.demo01.predicate;

import java.util.function.Predicate;

/**
 *   java.util.function.Predicate<T> 接口
 *   作用：对某种数据类型类型进行判断，结返回一个boolean值
 *   Predicate接口中包含一个抽象方法
 *      boolean test(T t)  对指定数据类型经进行判断
 *      结果：
 *         符合条件，返回true
 *         否则：返回false
 */
public class Demo01Predicate {
    /**
     *   定义一个方法，传递一个String类型字符串，再传递一个接口
     */
    public static boolean checkString(String str, Predicate<String> pre) {
        return pre.test(str);
    }

    public static void main(String[] args) {
        //定义一个字符串
        String str = "好的嘛";
        boolean ans = checkString(str, (s)->{
            //对字符串长度是否大于5
            if (s.length() > 5) {
                return true;
            }
            return false;
        });
        System.out.println(ans);
    }
}
