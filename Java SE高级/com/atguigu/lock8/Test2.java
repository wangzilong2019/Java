package com.atguigu.lock8;

import java.util.concurrent.TimeUnit;

/**
 *  此时位俩个锁对象，不需要等待。
 */
public class Test2 {
    public static void main(String[] args) {
        Phone2 phone2 = new Phone2();
        Phone2 phone3 = new Phone2();

        new Thread(()->{
            phone2.sendMes();
        }, "A").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone3.call();
        }, "B").start();
    }
}

class Phone2 {
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

    //这里没有锁，不收同步代码块控制，首先调用
    public void hello() {
        System.out.println("hello");
    }
}