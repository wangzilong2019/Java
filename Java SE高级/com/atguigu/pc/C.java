package com.atguigu.pc;

import java.util.WeakHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  A执行完调用B，B执行完调用C，C执行完调用A
 */
public class C {
    public static void main(String[] args) {
        Data3 data3 = new Data3();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data3.printA();
            }
        }, "A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data3.printB();
        }}, "B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data3.printC();
            }
        }, "C").start();
    }
}

class Data3 {
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    private int num = 1;

    public void printA() {
        lock.lock();

        try {
            //业务，判断、执行、通知
            while (num != 1) {
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName() + "=>AAAAA");
            //通知唤醒指定的人B
            num = 2;
            condition2.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void printB() {
        lock.lock();

        try {
            //业务，判断、执行、通知
            while (num != 2) {
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName() + "=>BBBBB");
            //通知唤醒指定的人C
            num = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void printC() {
        lock.lock();

        try {
            //业务，判断、执行、通知
            while (num != 3) {
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName() + "=>CCCCC");
            //通知唤醒指定的人C
            num = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
