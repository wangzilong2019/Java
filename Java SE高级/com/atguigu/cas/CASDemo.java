package com.atguigu.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {
    //CAS  比较并交换
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(2020);

        //期望更新
        //如果期望值正确则更新，否则不更新
        System.out.println(atomicInteger.compareAndSet(2020, 2021));;
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(2020, 2021));;
        System.out.println(atomicInteger.get());
    }
}
