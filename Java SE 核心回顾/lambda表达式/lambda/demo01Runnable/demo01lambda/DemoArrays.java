package com.lambda.demo01Runnable.demo01lambda;

import java.util.Arrays;
import java.util.Comparator;

public class DemoArrays {
    public static void main(String[] args) {
        //创建对象数组
        Person[] arr = {
                new Person("小明", 19),
                new Person("小张", 20),
                new Person("小巴", 10)
        };

//        //按照年龄升序排序
//        Arrays.sort(arr, new Comparator<Person>() {
//            @Override
//            public int compare(Person person, Person t1) {
//                return person.getAge() - t1.getAge();
//            }
//        });

        //使用lambda表达式排序
        Arrays.sort(arr, ((person, t1) -> {
            return person.getAge() - t1.getAge();
        }));

        //将结果输出
        for (Person p : arr) {
            System.out.println(p);
        }
    }
}
