package com.atguigu.rw;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *  独占锁（写锁）一次只能被一个线程占有
 *  共享锁（读锁）多个线程可以同时占有
 *  读-读 可以共存
 *  读-写 不能共存
 *  写-写 不能共存
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCacheLock myCache = new MyCacheLock();

        //写入
        for (int i = 1; i < 6; i++) {
            final int temp = i;
            new Thread(()->{
                myCache.put(temp + "", temp + "");
            }, String.valueOf(i)).start();
        }

        //读取
        for (int i = 1; i < 6; i++) {
            final int temp = i;
            new Thread(()->{
                myCache.get(temp + "");
            }, String.valueOf(i)).start();
        }
    }
}

//自定义缓存
class MyCacheLock {
    private volatile Map<String, Object> map = new HashMap<>();
    //读写锁，更加细粒度的控制
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    //读写的时候同时只希望有一个线程存在
    public void put(String key, Object value) {
        //添加写锁
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "写入" + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写入OK");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放写锁
            readWriteLock.writeLock().unlock();
        }
    }
    //写
    public void get(String key) {
        //读锁
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "读取" + key);
            Object value = map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取OK");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放读锁
            readWriteLock.readLock().unlock();
        }
    }
}

//自定义缓存
class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();

    //存、写
    public void put(String key, Object value) {
        System.out.println(Thread.currentThread().getName() + "写入" + key);
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + "写入OK");
    }
    //写
    public void get(String key) {
        System.out.println(Thread.currentThread().getName() + "读取" + key);
        Object value = map.get(key);
        System.out.println(Thread.currentThread().getName() + "读取OK");
    }
}