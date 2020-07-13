package com.functioninterface.demo01.consumer;

import javax.crypto.spec.PSource;
import java.util.function.Consumer;

/**
 *   Consumer 接口的默认方法andThen
 *   作用：需要俩个Consumer接口，可以把俩个Consumer接口组合到一起，再对数据进行消费
 *   例如：
 *       Consumer<String> con1
 *       Consumer<String> con1
 *       String s = "hello";
 *       con1.accept(s);
 *       con2.accept(s);
 *       连接来个Consumer接口，再进行消费
 *       con1.andThen(con2).accept(s);   谁先前面谁先消费
 */
public class Demo02AndThen {
    /**
     *   定义一个方法，方法的参数传递一个字符串和俩个接口
     */
    public static void method(String s, Consumer<String> con1, Consumer<String> con2) {
//        con1.accept(s);
//        con2.accept(s);

        //连接俩个Consumer接口，再进行消费(多个接口连接)
        con1.andThen(con2).accept(s);
    }

    public static void main(String[] args) {
        //调用method方法，传递一个字符串俩个lambda表达式
        method("HellO", (t)-> {
            //消费方法：转大写输出
            System.out.println(t.toUpperCase());
        }, (m)-> {
            //消费方式：转小写输出
            System.out.println(m.toLowerCase());
        });
    }
}
