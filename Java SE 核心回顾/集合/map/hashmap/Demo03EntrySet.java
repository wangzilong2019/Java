package com.map.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *    使用键值对遍历map集合
 *       1、首先使用map集合中的entrySet(0方法获取entry对象且存储在set集合中
 *       2、遍历set集合，获取每一个entry对象
 *       3、通过entry集合中的getKey()和getValue()方法获取每个entry对象的键值对
 *
 * */
public class Demo03EntrySet {
    public static void main(String[] args) {
        //创建一个map集合（多态）
        Map<String, Integer> map = new HashMap<>();

        map.put("马龙", 175);
        map.put("樊振东", 170);
        map.put("张继科", 180);

        //创建set集合存储entry对象
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        //遍历set集合
        for (Map.Entry<String, Integer> e : set) {
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + "=" + value);
        }
    }
}
