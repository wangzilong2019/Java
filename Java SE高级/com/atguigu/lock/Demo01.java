package com.atguigu.lock;

public class Demo01 {
    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(()->{
            phone.sms();
        }, "a").start();

        new Thread(()->{
            phone.call();
        }, "b").start();
    }
}

class Phone{
    public synchronized void sms() {
        System.out.println(Thread.currentThread().getName() + "sms");
        //这里也有锁
        call();
    }

    public synchronized void call() {
        System.out.println(Thread.currentThread().getName() + "call");
    }
}