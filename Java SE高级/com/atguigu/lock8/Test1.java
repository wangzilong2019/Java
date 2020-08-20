package com.atguigu.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 8锁，其实就是锁的8个问题
 * 当此时锁对象位方法的调用者，只有一个对象，有谁优先获取的锁对象优先调用谁，释放后另一个获取锁对象依次排队
 */
public class Test1 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(()->{
            phone.sendMes();
        }, "A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            phone.call();
        }, "B").start();
    }
}


class Phone {
    //synchronized锁的对象是方法的调用者
    //俩个对象使用同一个锁，谁先拿到，谁先执行
    public synchronized void sendMes() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }
    public synchronized void call() {
        System.out.println("打电话");
    }
}