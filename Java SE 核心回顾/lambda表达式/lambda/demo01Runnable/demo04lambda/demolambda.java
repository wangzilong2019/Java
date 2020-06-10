package com.lambda.demo01Runnable.demo04lambda;

/**
 *   lambda表达式可推导可省略
 *      1、(参数列表)：括号中的数据类型可以省略不写
 *      2、(参数列表)：括号中参数如果只有一个，那么类型和()都可以省略
 *      3、一些代码：如果{}中的代码只有一行，无论是否有返回值都可以省略{},return和分号
 *         注意：上者必须三者同时省略。也可以只省略参数类型
 *
 * */

public class demolambda {
    public static void main(String[] args) {
        //调用函数求俩个数字的和
        invokeCalc(1, 2, (a,b)-> a + b
        );
    }

    //定义一个方法，调用接口中的方法求俩个数字的和
    public static void invokeCalc(int a, int b, Calculator calc) {
        int res = calc.calc(a, b);
        System.out.println(res);
    }
}
