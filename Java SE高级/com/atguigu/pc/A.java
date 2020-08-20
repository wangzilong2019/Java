package com.atguigu.pc;

import java.util.Date;

/**
 * 生产者和消费者问题：线程通信问题 等待唤醒、通知唤醒
 */
public class A {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.increment();
            }
        }, "A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.decrement();
            }
        }, "B").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.increment();
            }
        }, "C").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.decrement();
            }
        }, "D").start();
    }
}

//判断等待、业务、通知
class Data {
    private int number = 0;

    //+1
    public synchronized void increment() {
        //使用while而不用if是为了避免线程的虚假唤醒问题
        while (number != 0) {
            //等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number++;
        System.out.println(Thread.currentThread().getName() + "->" + number);
        //通知其它线程+1完毕了
        this.notifyAll();
    }

    //-1
    public synchronized void decrement() {
        while (number == 0) {
            //等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "->" + number);
        //通知其它线程-1完毕了
        this.notifyAll();
    }
}