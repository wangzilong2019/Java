package com.file.demo01file.writer;

import java.io.FileWriter;
import java.io.IOException;

/**
 *   字符输入流
 *      构造方法：
 *          FileWriter(String name);
 *          FileWriter(File file);
 *      作用：
 *          创建一个FileWriter对象
 *          根据构造方法的文件/文件路径，创建文件
 *          将FileWriter对象指向创建好的文件
 *      使用步骤：
 *          创建FileWriter对象
 *          调用write方法将数据写入到内存缓冲区（字符转换为字节的过程）
 *          调用flush方法，将内存缓冲区中的数据，写入到文件中
 *          释放资源（会先把内存缓冲区的数据刷新到文件中）
 *
 */
public class Demo01FileWriter {
    public static void main(String[] args) throws IOException {
        FileWriter fr = new FileWriter("b.txt");
        //将数据写入到内存缓冲区
        fr.write(97);
        //将数据从内存缓冲区刷新到文件中
        fr.flush();
        //关闭资源（此时会自动将数据刷新到文件中）
        fr.close();
    }
}
