package com.file.demo01file.printstream;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 *     java.io.PrintStream
 *        PrintStream 为其他输出流添加了功能，使它们能够方便地打印各种数据值表示形式。
 *      特点：
 *        与其他输出流不同，PrintStream 永远不会抛出 IOException；
 *        只负责数据的输出，不负责数据的读取
 *      特有的成员方法：
 *        void print(任意类型数据)
 *        void println(任意类型数据并换行)
 *      构造方法：
 *        PrintStream(File file)
 *           创建具有指定文件且不带自动行刷新的新打印流。
 *        PrintStream(OutputStream out)
 *           创建新的打印流。
 *        PrintStream(String fileName)
 *           创建具有指定文件名称且不带自动行刷新的新打印流。
 *       PrintStream extends OutputStream
 *       继承自父类的成员方法：
 *   * *  *            void close()
 *  *  *  *           关闭此输出流并释放与此流有关的所有系统资源。
 *  *  *  *            void flush()
 *  *  *  *           刷新此输出流并强制写出所有缓冲的输出字节。
 *  *  *  *            void write(byte[] b)
 *  *  *  *           将 b.length 个字节从指定的 byte 数组写入此输出流。
 *  *  *  *            void write(byte[] b, int off, int len)
 *  *  *  *           将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此输出流。
 *  *  *  *            abstract  void write(int b)
 *  *  *  *           将指定的字节写入此输出流。
 *
 *     注意事项：
 *         如果使用继承自父类的成员方法write()方法写数据，那么查看数据的时候会查询编码表：a->97
 *         如果使用自己特有的成员方法print，println方法写数据，写的数据是原样
 */
public class Demo01PrintStream {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream pr = new PrintStream("d.txt");
        //调用父类的方法写入数据
        pr.write(97);
        //调用特有的成员方法写入数据
        pr.println(97);
        pr.close();
    }
}
