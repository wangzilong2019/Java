package com.thread;

public class DemoMainThread {

    /**
     *   主线程：执行主方法的线程
     *   单线程程序：
     *      Java程序中只有一个线程，执行从main方法开始，从上到下依次执行
     * */
    public static void main(String[] args) {
        Person p1 = new Person("小强");
        p1.run();
        Person p2 = new Person("旺财");
        p2.run();
    }
}
