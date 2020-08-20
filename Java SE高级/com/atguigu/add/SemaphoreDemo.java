package com.atguigu.add;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 类似于抢车位案例（6辆车抢3个车位）
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        //线程数量
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i < 6; i++) {
            new Thread(()->{
                // acquire()得到
                try {
                    //获得，如果已经满了，等待，等待倍释放为止
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "抢到车位");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + "离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //释放、会将当前的信号量释放+1，然后唤醒等待的线程
                    semaphore.release();  //释放
                }
            }, String.valueOf(i)).start();
        }
    }
}
