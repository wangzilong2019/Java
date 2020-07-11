package com.file.demo01file.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *    定义了子类方法
 *       int read() 从输入流中读取数据的下一个字节
 *       int read(byte[] b)  从输入流中读取一定数量的字节，将其存储在缓冲区数组b中
 *     构造方法
 *        FileInputStream(String name)   创建一个向指定名称的文件读出数据的文件输出流
 *        FileInputStream(File file) 创建一个向指定File对象文件中写入数据的文件输出流
 *      构造方法作用：
 *        创建一个FileInputStream对象
 *        会把FileInputStream对象指定构造方法中要读取的文件
 *fa
 *      读取数据的原理（硬盘-》内存）
 *         Java程序-》JVM-》OS->OS读取数据的方法-》读取文件
 *       使用步骤：
 *         创建FileInputStream对象
 *         使用read方法读取数据
 *         关闭流
 */
public class Demo11FileInputStream {
    //read读取一个文件并返回，读取到文件结尾返回-1
    /**
     *   从文件中一个一个读取字节
     */
    public static void show () {
        FileInputStream fis = null;
        try {
            //1、创建对象
            fis = new FileInputStream("a.txt");
//            int len = fis.read();  //91
//            System.out.println(len);
//            len = fis.read();  //98
//            System.out.println(len);
//            len = fis.read();
//            System.out.println(len);

            //使用while循环读取
            /**
             *   这里注意必须要用一个变量来接受读取的数据否则会跳读
             */
            int len = 0;
            while ((len = fis.read()) != -1) {
                System.out.println(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**  int read(byte[] bytes)
     *   将文件中数据读取到字节数组中，一次读取多个字节
     *      参数：byte[]数组的作用，起到缓冲作用，存储每次读取的字节
     *            int len 每次读取字节的长度一般为1024字节
     */
    public static void show2 () {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("b.txt");
//            byte[] bytes = new byte[2];
//            int len = fis.read(bytes);   //len代表每次读取字节的个数
//            System.out.println(new String(bytes));

            //循环输出读出的数据
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fis.read(bytes)) != -1) {
                //System.out.println(new String(bytes));  //此时会输出空格，因为字节数组长度为1024
                System.out.println(new String(bytes, 0, len));  //使用此方法输出无空格
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        show();
        show2();
    }
}
