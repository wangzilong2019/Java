package com.lambda.demo01Runnable.demo03lambda;

public class DemoCalc {
    public static void main(String[] args) {
        //调用函数求俩个数字的和
        invokeCalc(1, 2, (int a, int b)->{
            return a + b;
        });
    }

    //定义一个方法，调用接口中的方法求俩个数字的和
    public static void invokeCalc(int a, int b, Calculator calc) {
        int res = calc.calc(a, b);
        System.out.println(res);
    }
}
