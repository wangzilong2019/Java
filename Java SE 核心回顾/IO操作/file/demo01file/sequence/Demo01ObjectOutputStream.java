package com.file.demo01file.sequence;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *   java.io.ObjectOutputStream extends OutputStream
 *        ObjectOutputStream  对象的序列化流
 *        作用：把对象以流的形式写入到文件中保存
 *     构造方法：
 *        ObjectOutputStream(OutputStream out)
 *           创建写入指定 OutputStream 的 ObjectOutputStream。
 *     参数：
 *        OutputStream out：字节输出流
 *      特有的成员方法：
 *        writeObject(Object obj)
 *           将指定的对象写入 ObjectOutputStream。
 *
 *     序列化前提：
 *         类必须实现Serializable接口
 *         必须存在类对象的class文件
 *
 */
public class Demo01ObjectOutputStream {
    public static void main(String[] args) throws IOException {
        //创建ObjectOutputStream对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("a.txt"));
        oos.writeObject(new Person("好还有", 18));
        oos.close();
    }
}
