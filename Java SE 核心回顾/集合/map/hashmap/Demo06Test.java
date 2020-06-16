package com.map.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *  统计字符串中每个字符出现的次数
 * */
public class Demo06Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();

        //创建hashMap集合
        Map<Character, Integer> map = new HashMap<>();

        //遍历字符串数组
        for (Character ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        //方式二
        for (Character ch : str.toCharArray()) {
            //判断字符串是否出现
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        for (Character key : map.keySet()) {
            int value = map.get(key);
            System.out.println(key + "=" + value);
        }
    }
}
