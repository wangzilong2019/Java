package com.file.demo01file.inputstreamreader;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *   java.io.InputStreamReader extends Reader
 *        继承父类共有的成员方法
 *             int read()
 *               读取单个字符。
 *             int read(char[] cbuf, int offset, int length)
 *                将字符读入数组中的某一部分。
 *        构造方法：
 *            InputStreamReader(InputStream in)
 *               创建一个使用默认字符集的 InputStreamReader。
 *            InputStreamReader(InputStream in, String charsetName)
 *               创建使用指定字符集的 InputStreamReader。
 *            参数：
 *               InputStream in：字节输入流，读取文件中保存的字节
 *               String charsetName：指定编码表的名称，不区分大小写，不指定默认是哟个UTF-8
 *         使用步骤：
 *            1、创建InputStreamReader对象，构造方法中指定字节输出流和编码表
 *  *         2、调用InputStreamReader对象的read()方法，把字符转换为字节存储在缓冲区
 *  *         4、释放资源
 *       `  注意事项：
 *             构造方法中的编码表要和文件的编码相同，否则会发生编码乱码现象
 */
public class Demo01 {
    public static void main(String[] args) throws IOException {
        read_utf_8();
    }

    public static void read_utf_8() throws IOException {
        FileInputStream fis = new FileInputStream("a.txt");
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        int len = 0;
        while ((len = isr.read()) != -1) {
            System.out.println((char) len);   //这里注意要转换为char类型，否则输出的是一个汉字的码值
        }
        isr.close();
    }
}
