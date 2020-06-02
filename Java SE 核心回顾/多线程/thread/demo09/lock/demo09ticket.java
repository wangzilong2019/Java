package com.thread.demo09.lock;

public class demo09ticket {
    public static void main(String[] args) {
        //创建实现类对象
        RunnableImple run = new RunnableImple();

        //创建Thread类对象，传递实现类对象作为参数
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        Thread t3 = new Thread(run);

        //启动线程
        t1.start();
        t2.start();
        t3.start();
    }
}
