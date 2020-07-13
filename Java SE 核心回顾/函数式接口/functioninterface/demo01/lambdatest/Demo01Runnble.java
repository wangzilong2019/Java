package com.functioninterface.demo01.lambdatest;

/**
 *   java.lang.Runnable 接口是一个函数式接口
 *
 */
public class Demo01Runnble {
    /**
     *   定义一个方法，参数为接口类型
     */
    public static void startThread(Runnable run) {
        //开启多线程
        new Thread(run).start();
    }

    public static void main(String[] args) {
        //调用startThread方法，参数为接口类型，传递实现类作为参数
        startThread(()-> System.out.println(Thread.currentThread().getName() + "线程启动了"));
    }
}
