package com.stream.demo01list.demo08skip;

import java.util.stream.Stream;

/**
 *   Stream流中skip方法用于跳过元素
 *   如果希望跳过前几个元素，可以使用skip方法获取一个截取之后的新流
 *   Stream<T> skip(long n)
 *      如果当前长度大于参数n，则跳过前n个，否则会得到一个长度为0的新流
 */
public class Demo01Skip {
    public static void main(String[] args) {
        String[] arr = {"小狗", "小猫", "大王"};
        Stream<String> stream = Stream.of(arr);

        //使用skip跳过前1个元素
        Stream<String> stream1 = stream.skip(1);

        //遍历
        stream1.forEach(name-> System.out.println(name));
    }
}
