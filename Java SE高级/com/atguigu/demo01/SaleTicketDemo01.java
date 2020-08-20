package com.atguigu.demo01;

public class SaleTicketDemo01 {
    /**
     * 并发：多个线程操作同一个资源类，把资源类丢进线程
     */
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        //执行并发操作
        new Thread(()-> {for (int i = 0; i < 60; i++) ticket.sale();}, "A").start();
        new Thread(()-> {for (int i = 0; i < 60; i++) ticket.sale();}, "B").start();
        new Thread(()-> {for (int i = 0; i < 60; i++) ticket.sale();}, "C").start();
    }
}

class Ticket {
    private int num = 50;

    //卖票方式
    //使用同步方法本质：队列、锁
    public synchronized void sale() {
        if (num > 0 ) {
            System.out.println(Thread.currentThread().getName() + "卖出了" + (num--) + "票，剩余：" + num);
        }
    }
}
