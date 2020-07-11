package com.file.demo01file.printstream;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 *   可以改变输出语句的目的地（打印流语句）
 *       输出语句，默认在控制台输出
 *       使用System.setOut()方法改变输出语句的目的地改为参数中传递打印流的目的地
 *          static void setOut(PrintStream out)
 *            重新分配标准输出流
 */
public class Demo02PrintStream {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("我在控制台输出");

        //设置打印流目的地
        PrintStream ps = new PrintStream("e.txt");
        //把输出语句中目的地改变为打印流的目的地
        System.setOut(ps);
        System.out.println("我在打印流目的地中输出");
    }
}
