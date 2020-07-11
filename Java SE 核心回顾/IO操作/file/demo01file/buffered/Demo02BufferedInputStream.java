package com.file.demo01file.buffered;

/**
 *   java.io.BufferedInputStream extends InputStream
 *       继承自父类的成员方法
 *          abstract  int read()
 *           从输入流中读取数据的下一个字节。
 *          int read(byte[] b)
 *           从输入流中读取一定数量的字节，并将其存储在缓冲区数组 b 中。
 *          int read(byte[] b, int off, int len)
 *           将输入流中最多 len 个数据字节读入 byte 数组。
 *          void close()
 *           关闭此输入流并释放与该流关联的所有系统资源。
 *       构造方法：
 *          BufferedInputStream(InputStream in)   创建一个BufferedInputStream并保存其参数，即输入流 in，以便蒋来使用
 *          BufferedInputStream(InputStream in, int size)  创建指定缓冲区大小 BufferedInputStream 并保存其参数，即输入流
 *       参数：
 *           可以传递一个FileOutputStream，缓冲流会给FileOutputStream增加一个缓冲区，提高FileOutputStream
 *           size:指定缓冲流大小，不指定默认
 *        使用步骤：
 *              创建BufferedInputStream对象
 *  *           创建BufferedInputStream对象
 *  *           调用BufferedInputStream对象的read()方法
 *  *           释放资源
 *         注意：当关闭资源时只需要关闭缓冲流资源就可以
 */
public class Demo02BufferedInputStream {
}
