package com.atguigu.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo02 {
    public static void main(String[] args) {
        Phone2 phone = new Phone2();

        new Thread(()->{
            phone.sms();
        }, "a").start();

        new Thread(()->{
            phone.call();
        }, "b").start();
    }
}

class Phone2{
    Lock lock = new ReentrantLock();

    public void sms() {
        lock.lock();  //细节问题，锁必须配对
        try {
            System.out.println(Thread.currentThread().getName() + "sms");
            //这里也有锁
            call();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void call() {

        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "call");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
