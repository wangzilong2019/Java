package com.functioninterface.demo01.lamda;

/**
 *   日志案例
 *      以下案例存在一些性能浪费问题
 *      在调用showLog方法时，传递的第二个参数是一个拼接后的字符串
 *      先把字符串拼接好，然后再调用showLog方法
 *      showLog方法如果传递的日志等级不是1
 *      那么拼接此字符串纯属浪费
 */
public class Demo01Logger {
    //定义一个根据日志的级别，显示日记信息的方法
    public static void showLog(int level, String message) {
        //如果日志级别对象1输出日志信息
        if (level == 1) {
            System.out.println(message);
        }
    }

    public static void main(String[] args) {
        //定义三个日志信息
        String mes1 = "hello";
        String mes2 = "world";
        String mes3 = "java";
        showLog(1, mes1+mes2+mes3);
    }
}
