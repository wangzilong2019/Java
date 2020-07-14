package com.stream.demo01list.demo09concat;

import java.util.stream.Stream;

/**
 *   Stream流中concat方法把俩个流合并乘一个流
 *
 */
public class Demo01Concat {
    public static void main(String[] args) {
        String[] arr = {"小狗", "小猫", "大王"};
        Stream<String> stream = Stream.of(arr);

        String[] arr2 = {"马龙", "张继科", "樊振东"};
        Stream<String> stream1 = Stream.of(arr2);
        //把俩个流合并成一个流
        Stream<String> stream2 = Stream.concat(stream, stream1);

        //遍历
        stream1.forEach(name-> System.out.println(name));
    }
}
