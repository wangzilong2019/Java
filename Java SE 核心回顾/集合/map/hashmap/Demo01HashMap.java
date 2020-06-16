package com.map.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 *    HashMap集合常用一些方法
 *         hashMap底层实现是哈希表
 *            jdk1.8之前：数组+单向链表
 *            jdk1.8之后：数组+单向链表/红黑树（当链表节点个数大于8个时为红黑树）
 *            是一个无序的集合
 *    LinkedHashMao集合：
 *         底层实现是：哈希表+单向链表（巴奥赵正得迭代的顺序）
 *         是一个有序的集合
 * */
public class Demo01HashMap {
    public static void main(String[] args) {
        //创建一个map集合（多态）
        Map<String, Integer> map = new HashMap<>();
        /**
         *   添加元素
         * */
        map.put("马龙", 175);
        map.put("樊振东", 170);
        map.put("张继科", 180);
        System.out.println(map);
        Integer hight = map.put("马龙", 178);  //这里接收相同的键被替代的值，若键在map集合中未出现，则返回null
        System.out.println(map);
        /**
         *  删除键值对
         * */
        Integer h = map.remove("樊振东");
        System.out.println(map);

        /**
         *  获取键对应的值
         * */
        Integer h2 = map.get("张继科");  //这里要用包装类型变量接收，因为当键不存在时返回null
        System.out.println(h2);

        /**
         *  判断集合是否包含键 或值
         * */
        boolean flag = map.containsKey("马龙");
        boolean flag2 = map.containsValue("180");
        System.out.println(flag);
        System.out.println(flag2);
    }
}
