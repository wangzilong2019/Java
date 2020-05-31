package com.thread.demo07;

public class ThreadSafe implements Runnable{
    //定义一个多线程的票源
    private int ticket = 100;

    /**
     *  线程安全问题：买票
     * */

    /**
     *  格式：
     *     synchronized(锁对象) {
     *         可能会出现线程安全问题的代码
     *     }
     * */
    /**
     *  同步代码块中锁对象可以是任意对象
     *  但必须保证多个线程使用的锁对象是同一个
     *  锁对象的作用：
     *      把同步代码块锁住，只让一个线程在同步代码块中执行
     * */

    //创建一个锁对象
    Object obj = new Object();

    //设置线程任务：卖票
    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                //判断是否存在票源
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "线程正在卖第" + ticket + "张票");
                    ticket--;
                }
            }
        }
    }
}
