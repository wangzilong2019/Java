package com.lambda.demo01Runnable;

public class RunnableImpl implements Runnable {
    @Override
    public void run() {
        System.out.println("使用Runable接口创建线程");
    }
}
