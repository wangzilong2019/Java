package com.file.demo01file.outputstreamwriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *   java.io.OutputStreamWriter extends Writer
 *         OutputStreamWriter 是字符流流向字节流的桥梁，可使用指定的charset将要写入流中的字符编码成字节
 *
 *   继承父类的共性成员方法：
 * *  *            void close()
 *  *  *           关闭此输出流并释放与此流有关的所有系统资源。
 *  *  *            void flush()
 *  *  *           刷新此输出流并强制写出所有缓冲的输出字节。
 *  *  *            void write(byte[] b)
 *  *  *           将 b.length 个字节从指定的 byte 数组写入此输出流。
 *  *  *            void write(byte[] b, int off, int len)
 *  *  *           将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此输出流。
 *  *  *            abstract  void write(int b)
 *  *  *           将指定的字节写入此输出流。
 *    构造方法：
 *       OutputStreamWriter(OutputStream out)
 *           创建使用默认字符编码的 OutputStreamWriter。
 *       OutputStreamWriter(OutputStream out, String charsetName)
 *           创建使用指定字符集的 OutputStreamWriter。
 *    参数：
 *       OutputStream out：字节输出流，可以用来转换之后的字节到文件中
 *       String charsetName：指定编码表的名称，不区分大小写，不指定默认是哟个UTF-8
 *     使用步骤：
 *         1、创建OutputStreamWriter对象，构造方法中指定字节输出流和编码表
 *         2、调用OutputStreamWriter对象的write()方法，把字符转换为字节存储在缓冲区
 *         3、调用OutputStreamWriter对象的flush()方法，把缓冲区数据刷新到文件中
 *         4、释放资源
 */
public class Demo01 {
    public static void main(String[] args) throws IOException {
        write_utf_8();
    }

    /**
     *   使用转换流OutputStreamWriter写UTF-8文件
     */
    public static void write_utf_8() throws IOException {
        FileOutputStream fos = new FileOutputStream("a.txt");
        //OutputStreamWriter osw = new OutputStreamWriter(fos);   //默认UTF-8编码
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        osw.write("你好");
        osw.flush();
        osw.close();
    }
}
