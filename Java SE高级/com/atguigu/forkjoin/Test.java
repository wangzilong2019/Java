package com.atguigu.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class Test {
    public static void main(String[] args) {
        test3();
    }

    //普通程序员
    public static void test1() {
        Long sum = 0L;
        Long start = System.currentTimeMillis();
        for (Long i = 1L; i <= 10_0000_0000; i++) {
            sum += i;
        }
        Long end = System.currentTimeMillis();
        System.out.println("sum = " + sum + "时间：" + (end - start));
    }
    //forkjoin
    public static void test2() {
        Long start = System.currentTimeMillis();

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //创建一个对象
        ForkJoinTask<Long> task = new ForkJoinDemo(0L, 10_0000_0000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);  //提交任务
        try {
            Long sum = submit.get();
            Long end = System.currentTimeMillis();
            System.out.println("sum = " + sum + "时间：" + (end - start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    /**
     * 使用stream并行流
     */
    public static void test3() {
        Long start = System.currentTimeMillis();
        Long sum = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0, Long :: sum);
        Long end = System.currentTimeMillis();
        System.out.println("sum = " + sum + "时间：" + (end - start));
    }
}
