package com.file.demo01file.sequence;

import java.io.*;
import java.util.ArrayList;

/**
 *   序列化集合：
 *      当我们要在一个文件中保存多个对象
 *      可以把多个对象保存到一个集合中
 *      对集合进行序列化和反序列化
 *    分析：
 *       1、定义一个存储Person对象的ArrayList的集合
 *       2、再集合中存储Person对象
 *       3、创建一个序列化流ObjectOutputStream对象
 *       4、调用writeObject()方法，对集合进行序列化
 *       5、创建一个反序列化ObjectInputStream集合
 *       6、调用readObject()方法将读取到的对象保存到集合中
 *       7、把Object类型集合转换为ArrayList类型
 *       8、遍历集合
 *       9、释放资源
 */
public class Demo03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //创建集合
        ArrayList<Person> list = new ArrayList<>();
        //向集合中添加对象
        list.add(new Person("好还有", 18));
        list.add(new Person("打包", 80));
        list.add(new Person("小狗", 90));
        //创建要对象写的目的地
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c.txt"));
        //对集合进行序列化操作
        oos.writeObject(list);
        //创建一个反序列化操作对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c.txt"));
        //读取对象集合
        Object o = ois.readObject();
        //转换集合类型
        ArrayList<Person> list1 = (ArrayList<Person>)o;
        //遍历集合
        for (Person person : list1) {
            System.out.println(person);
        }
        //释放资源
        oos.close();
        ois.close();
    }
}
