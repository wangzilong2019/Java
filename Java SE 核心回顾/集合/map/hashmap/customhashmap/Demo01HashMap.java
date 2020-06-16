package com.map.hashmap.customhashmap;

import java.util.HashMap;
import java.util.Map;

/**
 *   自定义类型存储作为hashMap键
 *      因为hashMap键必须唯一，所以自定义类时要重写hashCode()方法和equals()方法
 *
 * */
public class Demo01HashMap {
    public static void main(String[] args) {
        //创建一个map集合（多态）
        Map<Person, Integer> map = new HashMap<>();
        map.put(new Person("小王", 19), 180);
        map.put(new Person("小王", 19), 190);
        map.put(new Person("小丽", 80), 170);

        //遍历集合
        for (Map.Entry<Person, Integer> e : map.entrySet()) {
            Person key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + "=" + value);
        }

        for (Person e : map.keySet()) {
            Integer value = map.get(e);
            System.out.println(e + "=" + value);
        }
    }
}
