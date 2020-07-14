package com.stream.demo01list.demo04filter;

import java.util.stream.Stream;

/**
 *   Stream流中filter方法，对流中数据进行过滤
 *   filter方法参数Predicate是一个函数式接口
 */
public class Demo01Filter {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("小明", "小马", "xiaohua");
        //过滤
        Stream<String> stream1 = stream.filter((name)->name.startsWith("小"));
        //遍历
        stream1.forEach(name-> System.out.println(name));

        /**
         *   注意事项：
         *      Stream流属于管道流，只能使用一次自动关闭
         *      第一个Stream流调用完毕，数据就会转到下一个Stream上
         *      这时第一个Stream流使用完毕，就会关闭
         *      所以第一个Stream流就不能再调用方法
         */
    }
}
