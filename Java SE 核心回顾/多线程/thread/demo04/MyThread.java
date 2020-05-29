package com.thread.demo04;

//创建实现Runnable接口的类
public class MyThread implements Runnable{

    //重写run()方法设置线程任务
    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            System.out.println("run : " + i);
        }
    }
}
