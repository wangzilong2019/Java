package com.atguigu.bq;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 同步队列
 * 和其他的LockingQueue 不一样 SynchronousQueue不存储元素
 * put了一个元素 必须从里面先take取出来，否则不能再put进去值
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        SynchronousQueue<String> stringSynchronousQueue = new SynchronousQueue<>();

        new Thread(()->{
            try {
                System.out.println("put 1");
                stringSynchronousQueue.put(Thread.currentThread().getName() + "1");
                System.out.println("put 2");
                stringSynchronousQueue.put(Thread.currentThread().getName() + "2");
                System.out.println("put 3");
                stringSynchronousQueue.put(Thread.currentThread().getName() + "3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "T1").start();
        new Thread(()->{

            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + stringSynchronousQueue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + stringSynchronousQueue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + stringSynchronousQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "T2").start();
    }
}
