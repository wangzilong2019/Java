package com.file.demo01file.sequence;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *    java.io.ObjectInputStream extends InputStream
 *        ObjectInputStream  对象的反序列化流
 *    作用：
 *        把文件中保存的对象，以流的方式读取出来使用
 *    构造方法：
 *        ObjectInputStream(InputStream in)
 *           创建从指定 InputStream 读取的 ObjectInputStream。
 *    特有的成员方法：
 *         Object readObject()
 *           从 ObjectInputStream 读取对象。
 *
 *     static:静态关键字
 *         静态优先于非静态加载到内存中（静态优先于对象加载到内存中）
 *         被static修饰的成员变量不能被序列化，序列化的都是对象
 *     transient：瞬态关键字
 *         被transient修饰的成员变量不能被序列化
 *
 *     若age被static则age一直为0
 *
 */
public class Demo02ObjectInputStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("a.txt"));
        //从中读取一个对象
        Object o = ois.readObject();
        //释放资源
        ois.close();
        //打印对象
        System.out.println(o);
        if (o instanceof Person) {
            Person person = (Person)o;
            System.out.println(person);
        }
    }
}
