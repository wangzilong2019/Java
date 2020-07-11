package com.file.demo01file.stream;

import java.io.FileOutputStream;
import java.io.IOException;

public class Demo01FileOutputStream {
    /**
     *  构造方法：
     *      FileOutputStream(String name)   创建一个向指定名称的文件写入数据的文件输出流
     *      FileOutputStream(File file) 创建一个向指定File对象文件中写入数据的文件输出流
     *      参数：写入数据的目的地
     *           String name 目的地是一个文件路径
     *           File file  目的地是一个文件
     *       构造方法作用：
     *           创建一个FileOutputStream对象
     *           会根据构造方法中传递的文件路径，创建空的文件
     *           会把FileOutputStream对象指向创建好的文件
     *
     *   写入数据的原理（内存-》硬盘）
     *       Java程序-》jvm虚拟机-》OS（操作系统）-》OS调用写数据的方法-》把数据写入到文件中
     *
     *
     *    使用步骤：
     *       创建一个FileOutputStream对象
     *       调用write方法写入数据
     *       释放资源
     */

    /**
     *  向文件中写入一个字节
     *    public void write(int n);
     */
    public static void show() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("a.txt");
            /**
             *   在文件中会显示a  用了记事本原理
             *     写入97时会以二进制行式存储到硬盘，当记事本读取时会按照记事本原理显示
             */
            fos.write(97);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *   public void write(byte[] bytes);
     *   一次向文件中写入多个字节
     *      如果写入的第一个字节是正数（0-127），那么现实的时候会查询ASCII码表
     *      如果写入的第一个字节是负数那么第一个字节和第二个字节，俩个字节会组成一个中文显示，查询系统默认码表（GBK）
     */
    public static void show2() {
        byte[] bytes = {48, 49, 50};  //文件中显示 012
        byte[] bytes1 = {-10, 3, -2, 5, 7};
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("b.txt");
            //向文件中写入整个字节数组
            fos.write(bytes);
            //先文件中写入部分字节数组
            fos.write(bytes, 0, 1);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 写入字符的方法：可以使用String类中方法将字符串转换为字节数组
     */
    public static void show3() {
        String s = "你好";
        byte[] bytes = s.getBytes();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("b.txt");
            //向文件中写入整个字节数组
            fos.write(bytes);
            //先文件中写入部分字节数组
            fos.write(bytes, 0, 1);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        show();
        show2();
        show3();
    }
}
