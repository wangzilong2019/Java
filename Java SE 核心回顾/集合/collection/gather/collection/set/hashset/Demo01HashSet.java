package com.gather.collection.set.hashset;

import java.util.HashSet;
import java.util.Set;

/**
 *   HashSet接口继承了Set接口
 *       不允许存储重复元素
 *       无索引
 *       是一个无序的集合
 *       底层是一个哈希表结构，查询效率高
 *      注意：HashSet中集合不保证顺序的持久性
 *
 *   底层不是同步的，即单线程
 *
 * */
    public class Demo01HashSet {
        public static void main(String[] args) {
            Set<Integer> hashSet = new HashSet<>();
            hashSet.add(1);
            hashSet.add(2);
            hashSet.add(1);
            System.out.println(hashSet);
        }
    }
