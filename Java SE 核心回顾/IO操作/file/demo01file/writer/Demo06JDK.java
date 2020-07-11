package com.file.demo01file.writer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *    jdk9新特性
 *       在try前面可以定义流对象
 *       在try后面的括号中可以直接引入流对象的名称（变量名）
 *       在try代码执行完毕，也可以直接释放掉，不用再写finally
 *       格式：
 *           A a = new A();
 *           B b = new B();
 *           try(a; b) {
 *  *               可能会抛出异常的代码
 *  *           } catch(异常类变量 变量名) {
 *  *               异常的处理逻辑
 *  *           }
 */       // 一般使用jdk7新特性，因为jdk9还要抛出异常
public class Demo06JDK {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("D:\\324.01.jpg");
        FileOutputStream fos = new FileOutputStream("D:\\b.jpg");
        try (fis; fos) {
            //从文件中读取
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
