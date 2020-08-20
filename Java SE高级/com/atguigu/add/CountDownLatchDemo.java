package com.atguigu.add;

import java.util.concurrent.CountDownLatch;

//计时器
public class CountDownLatchDemo {
    public static void main(String[] args) {
        //总数量是6
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "Go out");
                countDownLatch.countDown();  //数量-1
            }, String.valueOf(i)).start();
        }
        //等待计数器归零，然后再向下执行
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("关门");
    }
}
