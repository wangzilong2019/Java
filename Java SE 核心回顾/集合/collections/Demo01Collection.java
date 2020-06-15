package com.collections;

import com.collections.sort.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Demo01Collection {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();


        //第二个参数为可变参数,即可以添加任意个元素
        //向集合中添加元素
        Collections.addAll(list, "小张", "小王", "往");
        System.out.println(list);

        //打乱集合中的顺序
        Collections.shuffle(list);
        System.out.println(list);

        //自定义类元素排序
        Person p1 = new Person("小张", 10);
        Person p2 = new Person("小王", 19);
        Person p3 = new Person("小周", 8);

        ArrayList<Person> list1 = new ArrayList<>();
        list1.add(p1);
        list1.add(p2);
        list1.add(p3);

        //方法一按照年龄升序排序
        Collections.sort(list1, (o1, o2)->o1.getAge() - o2.getAge());
        System.out.println(list1);
        /**
         *  方法二：也可在在Person类创建时继承Comparable接口
         *        在其中重写compareTo()方法
         *
         * */
    }
}
