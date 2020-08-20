package com.atguigu.tvolatile;

import java.util.concurrent.atomic.AtomicInteger;

public class VDemo02 {
    //volatile 不保证原子性
    private volatile static AtomicInteger num = new AtomicInteger();

    public static void add() {
        num.getAndIncrement();  //加1操作 CAS
    }
    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }

        if (Thread.activeCount() > 2) {  //main gc
            Thread.yield();
        }
        System.out.println(num);
    }

}
