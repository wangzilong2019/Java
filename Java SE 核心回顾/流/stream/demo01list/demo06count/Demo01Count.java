package com.stream.demo01list.demo06count;

import java.time.temporal.JulianFields;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 *  Stream 流中count方法，用于统计Stream流中元素的个数
 *  long count()
 *  count方法是一个终结方法，返回值是一个long类型的整数
 *  不能再调用stream流中其它方法
 */
public class Demo01Count {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Stream<Integer> stream = list.stream();
        long count = stream.count();
        System.out.println(count);
    }
}
