package com.thread.demo02;

public class MyThread extends Thread{
    /**
     *   获取线程名称
     *      1、使用Thread类中的getName()方法
     *         String getName()返回该线程的名称
     *      2、可以先获取当前正在执行  的线程，使用线程中的getName()方法获取线程的名称
     *          static Thread currentThread()  返回当前当前正在执行的线程对象的引用
     *
     * */
    @Override
    public void run() {
        //方法一
        String name = getName();
        //System.out.println(name);

        //方法二
        Thread t = Thread.currentThread();
        System.out.println(t);
        name = t.getName();
        System.out.println(t);

        //方法三（链式编程）
        System.out.println(Thread.currentThread().getName());
    }
}
