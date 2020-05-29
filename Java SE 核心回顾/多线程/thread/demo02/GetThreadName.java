package com.thread.demo02;

public class GetThreadName {
    public static void main(String[] args) {
        //创建子类的实例对象
        MyThread myThread = new MyThread();
        //执行线程
        myThread.start();

        (new MyThread()).start();
    }
}
