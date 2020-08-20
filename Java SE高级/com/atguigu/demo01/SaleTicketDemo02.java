package com.atguigu.demo01;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicketDemo02 {
    /**
     * 并发：多个线程操作同一个资源类，把资源类丢进线程
     */
    public static void main(String[] args) {
        Ticket1 ticket = new Ticket1();

        //执行并发操作
        new Thread(()-> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }}, "A").start();
        new Thread(()-> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }}, "B").start();
        new Thread(()-> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }}, "C").start();
    }
}

class Ticket1 {
    private int num = 50;

    //获取Lock对象
    Lock lock = new ReentrantLock();
    //卖票方式
    public void sale() {
        //加锁
        lock.lock();
        try {
            //业务逻辑
            if (num > 0 ) {
                System.out.println(Thread.currentThread().getName() + "卖出了" + (num--) + "票，剩余：" + num);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //解锁
            lock.unlock();
        }
    }
}