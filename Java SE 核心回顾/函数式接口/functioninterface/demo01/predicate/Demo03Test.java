package com.functioninterface.demo01.predicate;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 *   要求：姓名长度必须小于4
 *        必须为女
 */
public class Demo03Test {
    /**
     *   定义一个方法，传递一个字符出纳和俩二接口
     */
    public static ArrayList<String> checkString(String[] arr, Predicate<String> pre1, Predicate<String> pre2) {
        //定义一个集合存储过滤之后的信息
        ArrayList<String> list = new ArrayList<>();
        //遍历字符串数组
        for (String str : arr) {
            //判断是否满足上述条件
            boolean flag = pre1.and(pre2).test(str);
            //满足条件加入集合
            if (flag) {
                list.add(str);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String[] arr = {"迪丽热巴,女", "杨静,男", "康辉,男", "尼格买提,女", "妮妮,女"};
        //调用过滤方法
        ArrayList<String> list = checkString(arr, (str)-> {
            //名字长度必须小于4
            String name = str.split(",")[0];
            return name.length() < 4;
        }, (str)-> {
            //是否为女
            String sex = str.split(",")[1];
            return sex.equals("女");
        });
        System.out.println(list);

    }
}
