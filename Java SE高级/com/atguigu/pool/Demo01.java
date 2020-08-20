package com.atguigu.pool;

import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Executor 工具类、3大方法
 */

/**
 * 四种拒绝策略
 * new ThreadPoolExecutor.AbortPolicy()银行满了，还有人要进去，不处理，抛出异常
 * new ThreadPoolExecutor.CallerRunsPolicy() 哪来的去哪里
 * new ThreadPoolExecutor.DiscardPolicy() 队列满了不会抛出异常
 * new ThreadPoolExecutor.DiscardPolicy() 队列满了
 */
public class Demo01 {
    public static void main(String[] args) {
        //单个线程
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();
        //ExecutorService threadPool = Executors.newFixedThreadPool(5); //创建5个现成的线程池
        //ExecutorService threadPool = Executors.newCachedThreadPool();  //可伸缩的，遇强则强，遇弱则弱

        /**
         *  - 定义最大线程
         * 1、CPU密集型 几核就定义为几，可以保持CPU效率最高
         * 2、IO密集型  > 程序中十分耗IO的线程，一般可以设置为耗IO资源线程的2倍
         */
        /**
         * //核心线程数
         * //最大线程数
         * //超时等待
         * //超时等待时间单位
         * //阻塞队列（候客区）
         * //线程工厂
         * //拒绝策略
         */
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());


        try {
            //最大承载：Deque + max
            //超过抛出异常
            for (int i = 0; i < 9; i++) {
                //使用线程池来创建线程
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName() + " ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭线程池
            threadPool.shutdown();
        }

        System.out.println(Runtime.getRuntime().availableProcessors());
        ArrayList<Integer> list = new ArrayList<>();
    }
}
