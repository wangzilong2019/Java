package com.thread;

/**
 *  等待唤醒案例
 *     创建一个顾客线程：告知老板要包子的数量和种类调用wait()方法，放弃cpu的执行，进入WAITING状态
 *     创建一个老板线程：花了5秒做包子，做好包子后调用notify方法唤醒顾客吃包子
 *
 *   注意：
 *      顾客和老板线程只能有一个线程在执行，必须用同步代码块包起来
 *      同步使用的锁对象必须唯一
 *      只有锁对象才能调用wait和notify方法
 *
 *    void wait()
 *        在其它方法调用此对象的notify方法或notifyALL()方法前，导致当前线程等待
 *    void notify()
 *        唤醒此对象监视器上等待的带个线程
 *        继续执行wait方法之后的代码
 *
 * */

public class demo10waitandnotify {
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
                        System.out.println("告知老板需要包子的种类和数量");
                        //调用wait方法放弃cpu的执行，进入到WAITING(无线等待状态)
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        //唤醒之后的代码
                        System.out.println("包子已经做好了");
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
                        obj.notify();
                    }
                }
            }
        }.start();
    }
}
