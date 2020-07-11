package com.file.demo01file.inputstreamreader;

import java.io.*;

/**
 *    练习：转换文件编码
 *        将GBK文件转换为UTF-8文件类型
 *    思路：
 *        先将GBK格式文件读取出来，然后再哟个UTF-8文件写进去
 */
public class Demo02Test {
    public static void main(String[] args) throws IOException {
        gbkToutf_8();
    }

    public static void gbkToutf_8() throws IOException {
        //创建InputStreamReader对象
        InputStreamReader isr = new InputStreamReader(new FileInputStream("D:\\b.txt"), "UTF-8");
        //创建OutputStreamWriter对象
        OutputStreamWriter osr = new OutputStreamWriter(new FileOutputStream("b.txt"), "UTF-8");
        //读取GBK文件并以UTF-8行式写进去
        int len = 0;
        while ((len = isr.read()) != -1) {
            osr.write(len);
        }
        isr.close();
        osr.close();
    }
}
