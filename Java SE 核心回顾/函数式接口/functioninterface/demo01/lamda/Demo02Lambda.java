package com.functioninterface.demo01.lamda;

/**
 *   使用mabda表达式优化案例
 *     lambda特点：延时加载
 *     lambda使用前提：必须存在函数式接口
 */
public class Demo02Lambda {
    private static void showLog(int level, MessageBuilder mb) {
        if (level == 1) {
            System.out.println(mb.buildMessage());
        }
    }

    public static void main(String[] args) {
        //定义三个日志信息
        String mes1 = "hello";
        String mes2 = "world";
        String mes3 = "java";

        //使用lambda表达式
        showLog(1,()-> mes1+mes2+mes3);

        /**
         *  使用lambda表达式作为参数传递，仅仅是把参数传递到showLog()方法中
         *  只有满足条件，等级为1
         *      才会调用接口的方法拼接字符串
         *  不满足条件
         *      也不会执行接口中的方法
         *   所以不存在性能浪费
         */
    }
}
