package com.file.demo01file.buffered;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *    java.io.BufferedOutputStream extends OutputStream
 *        继承父类的共享成员方法：
 *            void close()
 *           关闭此输出流并释放与此流有关的所有系统资源。
 *            void flush()
 *           刷新此输出流并强制写出所有缓冲的输出字节。
 *            void write(byte[] b)
 *           将 b.length 个字节从指定的 byte 数组写入此输出流。
 *            void write(byte[] b, int off, int len)
 *           将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此输出流。
 *            abstract  void write(int b)
 *           将指定的字节写入此输出流。
 *       构造方法：
 *           BufferedOutputStream(OutputStream out)
 *           创建一个新的缓冲输出流，以将数据写入指定的底层输出流。
 *          BufferedOutputStream(OutputStream out, int size)
 *           创建一个新的缓冲输出流，以将具有指定缓冲区大小的数据写入指定的底层输出流。
 *       参数：
 *          可以传递一个FileOutputStream，缓冲流会给FileOutputStream增加一个缓冲区，提高FileOutputStream
 *          size:指定缓冲流大小，不指定默认
 *        使用步骤：
 *           创建FileOutputStream对象
 *           创建BufferedOutputStream对象
 *           调用BufferedOutputStream对象的write()方法，把数据写入到缓冲区
 *           调用BufferedOutputStream对象的flush方法把内部缓冲区的数据，刷新到文件中
 *           释放资源
 */
public class Demo01BufferedOutputStream {
    public static void main(String[] args) {

        try {
            FileOutputStream fos = new FileOutputStream("a.txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            bos.write("把数据写入到内存缓冲区".getBytes());
            //将内存缓冲区数据刷新到文件中
            bos.flush();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
