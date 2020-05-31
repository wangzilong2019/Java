package com.thread.demo08;

public class FunctionThread implements Runnable{
    //定义一个多线程的票源
    private static int ticket = 100;

    /**
     *  同步方法解决线程安全问题
     *    格式：synchronized  返回值类型  函数名() {
     *        可能会出现线程安全问题的代码块
     *    }
     *
     * */


    /**
     *  线程安全问题：买票
     * */
    //设置线程任务：卖票
    @Override
    public void run() {
        while (true) {
            //payTicket();
            payTicketStatic();
        }
    }

    //定义一个同步方法
    public synchronized void payTicket() {
        //判断是否存在票源
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "线程正在卖第" + ticket + "张票");
            ticket--;
        }
    }

    //静态同步方法
    public static synchronized void payTicketStatic() {
        //判断是否存在票源
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "线程正在卖第" + ticket + "张票");
            ticket--;
        }
    }
}
