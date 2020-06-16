package com.map.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *   遍历map集合
 *
 * */
public class Demo02KeySet {
    public static void main(String[] args) {
        show();
    }

    /**
     *   方式一：通过键值对方式
     *     1、首先获取键集合set
     *     2、遍历键集合set使用get方法获取值
     * */
    public static void show() {
        //创建map集合
        Map<String, Integer> map = new HashMap<>();
        map.put("张继科", 180);
        map.put("樊振东", 180);
        map.put("许昕", 189);

        /**
         *  通过键值对遍历集合
         * */
        //获取set集合
        Set<String> set = map.keySet();
        for (String key : set) {
            int value = map.get(key);
            System.out.println(key + "=" + value);
        }
        /**
         *  也可用迭代器遍历集合
         * */
    }
}
