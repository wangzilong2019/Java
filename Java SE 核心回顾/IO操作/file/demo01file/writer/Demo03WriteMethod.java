package com.file.demo01file.writer;

import java.io.*;

/**
 *    写数据的其它方法：
 *         void write(char[] buf) ;  写入字符数组
 *         void write(char ch);  //写入字符
 *         void write(char[] buf, int off, int len);  写入部分字符数组
 *         void write(String string);  写入字符串
 */
public class Demo03WriteMethod {
    public static void main(String[] args) throws IOException {
        char[] chars = {'a', 'b', 'c', 'd'};
        FileWriter fr = new FileWriter("a.txt");
        //写入一个字符到缓冲区
        fr.write(97);
        //写入字符数组到缓冲区
        fr.write(chars);
        //写入字符数组部分到缓冲区
        fr.write(chars, 0, 2);
        //写入字符串到缓冲区
        fr.write("传智播客");
        //写入字符串部分到缓冲区
        fr.write("程序员",0 ,3);
        //刷新数据到文件中
        fr.flush();
        fr.close();
    }
}
