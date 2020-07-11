package com.file.demo01file.stream;

import java.io.FileOutputStream;
import java.io.IOException;

public class Demo02FileOutputStream {
    /**
     *   追加写/续写
     *   FileOutputStream(String name, boolean append)   创建一个向指定名称的文件写入数据的文件输出流
     *   FileOutputStream(File file, boolean append) 创建一个向指定File对象文件中写入数据的文件输出流
     *       boolean append：追加写开关
     *           true：创建对象时不会覆盖原文件，继续在文件末尾追加数据
     *           false：创建一个新的 文件覆盖原文件
     *
     *    写换行：
     *      windows：\r\n
     *      linux：/n
     *      mac：/r
     */
    public static void show() {
        FileOutputStream fos = null;
        String s = "你好";
        try {
            fos = new FileOutputStream("d.txt");
            //在文件中写入10个换行的你好
            for (int i = 0; i < 10; i++) {
                fos.write(s.getBytes());
                //写入换行符
                fos.write("\r\n".getBytes());
            }
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

    public static void main(String[] args) {
        show();
    }
}
