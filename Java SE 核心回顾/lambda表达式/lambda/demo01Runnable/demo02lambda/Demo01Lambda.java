package com.lambda.demo01Runnable.demo02lambda;

/**
 * lambda表达式标准格式
 *  1、一些参数
 *  2 、一个箭头
 *  3、一段代码
 *   格式：
 *    （参数列表）->{一些重写方法代码}
 *    ()：接口中抽象方法的参数列表
 *    ->：把参数传递给方法体
 *    {}：重写接口中抽象方法的方法体
 *
 * */

public class Demo01Lambda {
    public static void main(String[] args) {
        //使用lambda表达式创建线程
        /**
         *  1、()代表参数列表
         *  2、->代表将参数传递给后面的代码
         *  3、后面的输出语句即业务逻辑代码
         *
         * */
        new Thread(()-> {
                System.out.println("使用lambda表达式创建线程");
            }
        ).start();
    }
}
