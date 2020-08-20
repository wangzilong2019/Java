package com.atguigu.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 异步调用：Ajax
 */
public class Demo01 {
    public static void main(String[] args) {
        //发起一个请求
        //runAsync 无返回值的异步回调
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "runAsync=void");
        });
        System.out.println("1111");
        //获取阻塞执行结果
        try {
            completableFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //有返回值的异步回调
        CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName() + "supplyAsync=Integer");
            return 1024;
        });

        try {
            System.out.println(completableFuture1.whenComplete((t, u)->{
                System.out.println("t=" + t);  //正常的返回结果
                System.out.println("u=" + u);  //错误信息
            }).exceptionally((e)->{
                e.printStackTrace();
                return 223;   //可以获取到错误的返回结果
            }).get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
