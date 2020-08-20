package com.atguigu.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TestSpinLock {
    public static void main(String[] args) throws InterruptedException {
        //ReentrantLock lock = new ReentrantLock();

        //底层使用的CAS自旋锁
        SpinLockDemo lock = new SpinLockDemo();

        new Thread(()->{
            lock.myLock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unLock();
            }
        }, "t1").start();
        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            lock.myLock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unLock();
            }
        }, "t2").start();
    }
}
