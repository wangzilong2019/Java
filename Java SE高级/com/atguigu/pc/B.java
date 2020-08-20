package com.atguigu.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者和消费者问题：线程通信问题 等待唤醒、通知唤醒
 */
public class B {
    public static void main(String[] args) {
        Data2 data = new Data2();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.increment();
            }
        }, "A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.decrement();
            }
        }, "B").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.increment();
            }
        }, "C").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.decrement();
            }
        }, "D").start();
    }
}

//判断等待、业务、通知

/**
 * condition.await();  等待
 * condition.signalAll();  唤醒全部线程
 */
class Data2 {
    private int number = 0;

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    //+1
    public void increment() {
        lock.lock();
        try {
            //使用while而不用if是为了避免线程的虚假唤醒问题
            while (number != 0) {
                //等待
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "->" + number);
            //通知其它线程+1完毕了
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    //-1
    public void decrement() {
        lock.lock();
        try {
            //使用while而不用if是为了避免线程的虚假唤醒问题
            while (number == 0) {
                //等待
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "->" + number);
            //通知其它线程+1完毕了
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}