package com.atguigu.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) {
        new Thread().start();  //怎么启动call
        MyThread thread = new MyThread();
        //适配类
        FutureTask futureTask = new FutureTask(thread);

        new Thread(futureTask, "A").start();
        //new Thread(futureTask, "A").start();  结果方法入缓存
        //获取call的返回结果
        try {
            Integer res = (Integer) futureTask.get();
            System.out.println(res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}

class MyThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("call()");
        return 1024;
    }
}