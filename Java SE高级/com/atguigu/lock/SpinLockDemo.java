package com.atguigu.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 */
public class SpinLockDemo {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    //加锁
    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "==> myLock");

        //自旋锁
        while (!atomicReference.compareAndSet(null, thread)) {

        }
    }

    //解锁
    public void unLock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "==> myUnLock");
        atomicReference.compareAndSet(thread, null);
    }

}
