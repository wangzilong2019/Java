package com.stream.demo01list.demo05map;

import java.util.stream.Stream;

/**
 * r 如果要将流中的元素映射到另一个流中，可以使用map方法
 *   该接口选择一个Function 函数式接口作为参数
 */
public class Demo01Map {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("1", "2", "3", "4");
        //使用映射，把字符串类型转换为整数
        Stream<Integer> map = stream.map(value->Integer.parseInt(value));

        //遍历
        map.forEach(i-> System.out.println(i));
    }
}
