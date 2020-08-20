package com.atguigu.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CASDemo03 {
    public static void main(String[] args) {
        //注意如果泛型是包装类，注意对象的引用问题
        AtomicStampedReference<Integer> atomicInteger = new AtomicStampedReference<>(1, 1);

        new Thread(()->{
            int stamp = atomicInteger.getStamp();  //获取当前版本号
            System.out.println("a1=" + stamp);

            //加延迟保证版本号是同一个
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            atomicInteger.compareAndSet(1, 2,
                    atomicInteger.getStamp(), atomicInteger.getStamp() + 1);

            System.out.println("a2=" + atomicInteger.getStamp());

            atomicInteger.compareAndSet(2, 1,
                    atomicInteger.getStamp(), atomicInteger.getStamp() + 1);

            System.out.println("a3=" + atomicInteger.getStamp());
        }, "a").start();

        new Thread(()->{
            int stamp = atomicInteger.getStamp();  //获取当前版本号
            System.out.println("b1=" + stamp);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            atomicInteger.compareAndSet(1, 6, stamp, stamp + 1);
            System.out.println("b1=" + atomicInteger.getStamp());

        }, "b").start();

    }
}
