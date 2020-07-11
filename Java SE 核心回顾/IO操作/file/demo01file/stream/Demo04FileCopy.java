package com.file.demo01file.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo04FileCopy {
    /**
     *     文件复制原理：
     *         从一个文件中读出，再写入另一个文件
     */
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\324.01.jpg");
        FileOutputStream fos = new FileOutputStream("D:\\b.jpg");
        //从文件中读取
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }
        fis.close();
        fos.close();
    }
}
