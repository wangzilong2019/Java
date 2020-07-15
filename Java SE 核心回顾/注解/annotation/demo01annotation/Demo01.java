package com.annotation.demo01annotation;

/**
 *    jdk中预定义的一些注解
 *      @override  ：检测被该注解标识的方法是否是继承父类的
 *      @Deprecated ：该注解标识的内容，表示已过时
 *      @supperessWarnings ：压制警告
 */

//压制所有警告
@SuppressWarnings("all")
public class Demo01 {

    @Override
    public String toString() {
        return super.toString();
    }

    @Deprecated
    public void show1() {

    }

    public void show2() {
        show1();
    }
}
