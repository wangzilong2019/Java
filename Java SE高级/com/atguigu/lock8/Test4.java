package com.atguigu.lock8;

import java.util.concurrent.TimeUnit;

/**
 *  当只有锁同一个对象时，才会等待
 *  此种情况下锁对象为class模板和类对象
 */
public class Test4 {


    public static void main(String[] args) {
        Phone4 phone = new Phone4();

        new Thread(()->{
            phone.sendMes();
        }, "A").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone.call();
        }, "B").start();
    }

}

//Phone3 的唯一一个class对象
class Phone4 {
    //静态同步方法，锁的是class模板
    public static synchronized void sendMes() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    //普通同步方法，锁的是对象
    public synchronized void call() {
        System.out.println("打电话");
    }
}