package com.thread.demo05;

public class InnerClassThread {
    /*
    *   匿名内部类实现线程的创建
    *
    *   匿名：没有名字
    *   内部类：写在其它类内部的类
    *
    *   匿名内部类的作用：简化代码
    *        把子类继承父类，重写父类方法，创建子类对象一步完成
    *        把实现类的接口，重写接口中的方法，创建实现类对象一步完成
    *   匿名内部类最终产物，子类 / 实现类对象，而这个类没有名字
    *
    *    格式：
    *      new  父类/接口{
    *           重写父类/接口中的方法
    *      };
    * */

    public static void main(String[] args) {
        //线程的父类是Thread
        new Thread() {
            //重写run()方法，设置线程任务

            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName() + " --> 黑马 " +i);
                }
            }
        }.start();

        //线程的接口Runnable实现
        Runnable r = new Runnable() {

            //设置线程任务
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName() + " --> 程序员 " +i);
                }
            }
        };
        new Thread(r).start();

        //接口的简化实现方式
        new Thread(new Runnable() {

            //设置线程任务
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName() + " --> alibaba " +i);
                }
            }
        }).start();
    }
}
