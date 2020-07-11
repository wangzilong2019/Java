package com.file.demo01file.buffered;

/**
 *    java.io.BufferedWriter extends Writer
 *
 */

/**
 *  *        继承父类的共享成员方法：
 *  *            void close()
 *  *           关闭此输出流并释放与此流有关的所有系统资源。
 *  *            void flush()
 *  *           刷新此输出流并强制写出所有缓冲的输出字节。
 *  *            void write(byte[] b)
 *  *           将 b.length 个字节从指定的 byte 数组写入此输出流。
 *  *            void write(byte[] b, int off, int len)
 *  *           将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此输出流。
 *  *            abstract  void write(int b)
 *  *           将指定的字节写入此输出流。
 *           构造方法：
 *              BufferedWriter(Writer out)
 *                创建一个使用默认大小输出缓冲区的缓冲字符输出流。
 *              BufferedWriter(Writer out, int sz)
 *                创建一个使用给定大小输出缓冲区的新缓冲字符输出流。
 *           参数：
 *              传递FileWriter，缓冲流会给FileWriter增加一个缓冲区，提高写入效率
 *              sz：指定缓冲区的大小，不写则默认大小
 *        特有的成员方法：
 *            void newLine()
 */
public class Demo03BufferedWriter {
}
