package com.file.demo01file.reader;

import java.io.FileReader;
import java.io.IOException;

/**
 *   字符流：
 *      构造方法：
 *         FileReader(String name);
 *         FileReader(File file);
 *      作用：
 *         1、创建一个FileReader对象
 *         2、把FileReader对象指向要读取的文件
 *      使用步骤：
 *         创建FileReader对象
 *         调用read方法读取文件
 *         释放资源
 */
public class Demo01FileReader {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("a.txt");
        int len;
//        while ((len = fr.read()) != -1) {
//            System.out.print((char)len);
//        }

        //使用字符数组来读取
        char[] chars = new char[1024];
        while ((len = fr.read(chars)) != -1) {
            System.out.print(new String(chars, 0, len));
        }
        fr.close();
    }
}
