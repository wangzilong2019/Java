package com.thread.demo09.lock;

/*
*    lock锁实现了比synchronized 更广泛的锁定操作
*     lock接口中的方法
*       void lock()   获取锁
*       void unlock()  释放锁
*
*     使用步骤：
*        1、在成员位置创建一个ReentrantLock对象
*        2、在可能出现安全问题的代码前调用Lock接口中的方法lock获取锁
*        3、在可能出现安全问题的代码前调用Lock接口中的方法unlock获取锁
*
* */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RunnableImple implements Runnable{
    private static int ticket = 100;

    //1、在成员位置创建一个ReentrantLock对象
    Lock l = new ReentrantLock();

    @Override
    public void run() {
        //重复卖票操作
        while (true) {
            //2、在可能出现安全问题的代码前调用Lock接口中的方法lock获取锁
            l.lock();

            //判断是否存在票源
            if (ticket > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //3、在可能出现安全问题的代码前调用Lock接口中的方法unlock获取锁
                    l.unlock();  //无论程序是否异常，都会释放锁对象，写在这里更便捷
                }
                System.out.println(Thread.currentThread().getName() + "线程正在卖第" + ticket + "张票");
                ticket--;
            }

        }
    }
}
