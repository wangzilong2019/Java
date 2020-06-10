package com.lambda.demo01Runnable;

public class Demo01Runnable {
    public static void main(String[] args) {
        //创建Runnable接口实现来对象
        RunnableImpl run = new RunnableImpl();
        //创建一个线程，实现类对象作为参数
        Thread t = new Thread(run);
        //启动线程
        t.start();

        //使用匿名内部类简化代码
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("使用匿名内部类创建线程");
            }
        };
        //启动线程
        new Thread(r).start();

        //简化代码
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("简化代码2创建线程");
            }
        }).start();
    }
}
