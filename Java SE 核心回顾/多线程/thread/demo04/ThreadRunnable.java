package com.thread.demo04;

public class ThreadRunnable {
    /**
     *  创建线程的第一种方法
     *    java.lang.Runnable 接口应该由那些打算通过某一线程执行其实例的类来实现，类必须定义一个run()的无参方法
     *    java.lang.Thread 类的构造方法
     *       Thread(Runnable target)  分配新的Thread对象
     *       Thread(Runnable target, String name) 分配新的Thread对象
     *
     *   步骤：
     *     1、创建一个实现Runnable接口的类
     *     2、在类中重写run()方法，设置线程任务
     *     3、创建一个Runnable实现类的对象
     *     4、创建Thread类对象，构造方法中传递Runnable接口的实现类对象
     *     调用Thread类中的start()方法，开启新的线程执行run()方法
     * */

    public static void main(String[] args) {
        //创建实现类的实例
        MyThread mt = new MyThread();
        //创建一个线程，参数为实现类实例
        Thread t = new Thread(mt);
        //调用Thread类中的start()方法开启新的线程执行run()方法
        t.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("main : " + i);
        }
    }
}
