package com.thread;

/**
 *   进入到TimeWaiting（记时等待）有俩种方式
 *      1、使用sleep(long m)方法，在毫秒值结束后，线程唤醒进入到Runnable/Blocked状态
 *      2、使用wait(long m)方法，wait方法在毫秒值结束胡，还没有被notify唤醒，就会自动醒来，线程唤醒进入Runnable/Blocked状态
 *
 *   唤醒的方法：
 *       void notify() 唤醒在此对象监视器上等待的单个线程
 *       void notify()  唤醒在此对象监视器上等待的所有线程
 */

public class demo11waitandnotify {
    public static void main(String[] args) {
        //创建 锁对象，保证唯一
        Object obj = new Object();
        //创建一个顾客线程
        new Thread() {
            @Override
            public void run() {
                //一直等着卖包子
                while (true) {
                    //使用同步技术 ，保证在等待线程和唤醒线程只有一个在执行
                    synchronized (obj) {
                        System.out.println("顾客1告知老板需要包子的种类和数量");
                        //调用wait方法放弃cpu的执行，进入到WAITING(无线等待状态)
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        //唤醒之后的代码
                        System.out.println("包子已经做好了，顾客1开吃");
                    }
                }
            }
        }.start();

        //创建一个顾客2线程
        new Thread() {
            @Override
            public void run() {
                //一直等着卖包子
                while (true) {
                    //使用同步技术 ，保证在等待线程和唤醒线程只有一个在执行
                    synchronized (obj) {
                        System.out.println("顾客2告知老板需要包子的种类和数量");
                        //调用wait方法放弃cpu的执行，进入到WAITING(无线等待状态)
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        //唤醒之后的代码
                        System.out.println("包子已经做好了，顾客2开吃");
                    }
                }
            }
        }.start();

        //创建老板线程
        new Thread() {
            @Override
            public void run() {
                //一直在卖包子
                while (true) {
                    //做包子花了5秒
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //使用同步技术 ，保证在等待线程和唤醒线程只有一个在执行
                    synchronized (obj) {
                        System.out.println("老板5秒后包子已经做好了，告知顾客");
                        //做好包子后，使用notify唤醒顾客吃包子
                        //obj.notify();  //随机唤醒一个线程

                        //唤醒所有线程
                        obj.notifyAll();
                    }
                }
            }
        }.start();
    }
}
