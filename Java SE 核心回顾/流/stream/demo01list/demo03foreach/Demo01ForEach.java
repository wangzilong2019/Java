package com.stream.demo01list.demo03foreach;

import java.util.stream.Stream;

/**
 *   Stream流中常用方法foreach
 *   该方法接收一个Consumer接口类型函数
 *    简单记：
 *       forEach方法，用来遍历流中的数据
 *       是一个终结方法，用来之后就不能遍历其它方法
 */
public class Demo01ForEach {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("小明", "小马", "xiaohua");

        //遍历
        stream.forEach(name-> System.out.println(name));
    }
}
