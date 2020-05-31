package com.thread.demo06;

public class ThreadSafe implements Runnable{
    //定义一个多线程的票源
    private int ticket = 100;

    /**
     *  线程安全问题：买票
     * */
    //设置线程任务：卖票
    @Override
    public void run() {
        while (true) {
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
}
