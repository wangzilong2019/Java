package com.thread.demo01;


public class Demo01Thread {
    public static void main(String[] args) {
        //创建子类的实例对象
        MyThread myThread = new MyThread();
        //执行线程
        myThread.start();

        for (int i = 0; i <= 20; i++) {
            System.out.println("main: " + i);
        }
    }
}
