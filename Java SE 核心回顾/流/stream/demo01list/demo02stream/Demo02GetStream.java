package com.stream.demo01list.demo02stream;

import com.sun.jdi.event.StepEvent;

import java.util.*;
import java.util.stream.Stream;

/**
 *  java.util.stream.Stream<T>是Java8新加入的常用接口（这不是一个函数式接口）
 *     获取流的常用方式：
 *       1、所有的Collection集合都可以通过stream默认方法获取流
 *          default Stream<E> stream()
 *       2、Stream接口静态方法of可以获取数组对应的流
 *          static <T> Stream<T> of(T...value)
 *          参数是一个可变参数，这这我们可以传递一个数组
 */
public class Demo02GetStream {
    public static void main(String[] args) {
        //把集合转换为Stream流
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        Set<String> set = new HashSet<>();
        Stream<String> stream1 = set.stream();

        Map<String, String> map = new HashMap<>();
        //获取键存储到set集合
        Set<String> set1 = map.keySet();
        Stream<String> stream2 = set1.stream();

        //获取值
        Collection<String> collection = map.values();
        Stream<String> stream3 = collection.stream();

        //获取键值对映射到entrySet集合
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        Stream<Map.Entry<String, String>> stream4 = entrySet.stream();

        //把数组转换为stream流
        Stream<Integer> stream5 = Stream.of(1,2,3,4);
        Integer[] arr = {1,2,34};
        Stream<Integer> stream6 = Stream.of(arr);
    }
}
