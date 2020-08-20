package com.atguigu.bq;

import java.sql.Time;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        //test1();
        //test2();
/*        try {
            test3();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        try {
            test4();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //抛出异常
    public static void test1() {
        //队列大小
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

        //查看队首元素
        System.out.println(blockingQueue.element());
        //System.out.println(blockingQueue.add("e"));  此时已满再添加抛出异常

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        //System.out.println(blockingQueue.remove());  此时队列为空抛出异常
    }

    public static void test2() {
        //队列大小
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));

        //检测队首元素
        System.out.println(blockingQueue.peek());
        //System.out.println(blockingQueue.offer("c"));  不跑出异常，返回false

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        //System.out.println(blockingQueue.remove());  此时队列为空  返回false
    }

    /**
     *  等待（阻塞-一直阻塞）
     */
    public static void test3() throws InterruptedException {
        //队列大小
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);

        //一直阻塞
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        //blockingQueue.put("d");  //队列无位置了一直阻塞

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());  //没有这个元素，一直阻塞
    }

    /**
     * 等待（阻塞-等待超时）
     */
    public static void test4() throws InterruptedException {
        //队列大小
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.offer("a");
        blockingQueue.offer("b");
        blockingQueue.offer("c");
        //blockingQueue.offer("d", 2, TimeUnit.SECONDS);  //队列满后等待2秒后退出

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll(2, TimeUnit.SECONDS));  //等待2秒后超时退出
    }
}

