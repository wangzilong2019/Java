package com.file.demo01file.writer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *    JDK7新特性
 *       再try后面可加一个()，在括号里定义流对象
 *       那么这个流对象的作用域就在try中有效
 *       try代码执行完毕，会自动将流对象释放，不用再写finally
 *        格式：
 *           try(定义流对象;定义流对象......) {
 *               可能会抛出异常的代码
 *           } catch(异常类变量 变量名) {
 *               异常的处理逻辑
 *           }
 */
public class Demo05JDK {
    public static void main(String[] args) {

        try (
                FileInputStream fis = new FileInputStream("D:\\324.01.jpg");
                FileOutputStream fos = new FileOutputStream("D:\\b.jpg");) {

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
