package com.functioninterface.demo01.consumer;

import java.util.function.Consumer;

/**
 *    使用andThen打印姓名：年龄
 *    要求将打印的姓名动作作为第一个Consumer接口的lambda实例
 *    打印的性别动作作为第二个Consumer接口的lambda实例
 *     将俩个Consumer接口按照顺序拼接到一起
 */
public class Demo03AndThenTest {
    /**
     *   定义一个方法，传递String类型数据和俩个Consumer接口，使用泛型String
    */
    public static void printInfor(String[] arr, Consumer<String> con1, Consumer<String> con2) {
        //遍历字符串数组
        for (String str : arr) {
            con1.andThen(con2).accept(str);
        }
    }

    public static void main(String[] args) {
        //定义一个字符串类型数组
        String[] arr = {"樊振东,男", "马龙,男", "陈梦,女"};
        printInfor(arr, (message)->{
            //消费方式：以逗号作为分隔符分割
            String name = message.split(",")[0];
            System.out.println("姓名：" + name);
        }, (message)-> {
            //消费方式：以逗号作为分隔符获取性别
            String sex = message.split(",")[1];
            System.out.println("性别：" + sex);
        });
    }
}
