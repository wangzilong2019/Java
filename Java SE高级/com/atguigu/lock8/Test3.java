package com.atguigu.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 当方法倍static修饰时，此时锁对象位class模板
 * 无论创建多少个对象调用方法此时锁对象只有一个即为class模板
 */
public class Test3 {
    public static void main(String[] args) {
        Phone3 phone3 = new Phone3();
        //Phone3 phone31 = new Phone3();
        new Thread(()->{
            phone3.sendMes();
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

//Phone3 的唯一一个class对象
class Phone3 {
    //synchronized锁对象是方法的调用者
    // static静态方法
    //类一加载就有了class模板，锁的是class
    public static synchronized void sendMes() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public static synchronized void call() {
        System.out.println("打电话");
    }

    //这里没有锁，不收同步代码块控制，首先调用
    public void hello() {
        System.out.println("hello");
    }
}