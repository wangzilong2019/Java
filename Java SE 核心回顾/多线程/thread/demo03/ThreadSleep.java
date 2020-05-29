package com.thread.demo03;

public class ThreadSleep {
    public static void main(String[] args) {

        /**
         *   使当前执行的线程以指定的毫秒暂停
         *      public static void sleep(long mills);
         * */
        //模拟秒表
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
