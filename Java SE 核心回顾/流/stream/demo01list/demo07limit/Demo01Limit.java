package com.stream.demo01list.demo07limit;

import java.util.stream.Stream;

/**
 *   Stream流中limit方法，用于截取流中元素
 *     limit方法可以可以对六进行截取，只能取前n个
 *     Stream<T>  limit(long maxsize) 如果集合当前长度大于参数则进行截取，否则不做处理
 *     limit方法是一个延迟方法，只是对流中的元素进行截取，所以可以继续调用Stream流中的其它方法
 */
public class Demo01Limit {
    public static void main(String[] args) {
        String[] arr = {"小狗", "小猫", "大王"};
        Stream<String> stream = Stream.of(arr);

        //使用limit方法对流进行截取
        Stream<String> stream1 = stream.limit(2);

        //遍历
        stream1.forEach(name-> System.out.println(name));
    }
}
