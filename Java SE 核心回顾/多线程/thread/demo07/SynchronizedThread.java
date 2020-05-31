package com.thread.demo07;

public class SynchronizedThread {
    public static void main(String[] args) {
        //创建Runnable接口的实现类对象
        ThreadSafe run = new ThreadSafe();
        //创建Thread类对象，构造方法中传递Runnable接口实现类对象
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        Thread t3 = new Thread(run);

        //启动线程任务
        t1.start();
        t2.start();
        t3.start();
    }
}
