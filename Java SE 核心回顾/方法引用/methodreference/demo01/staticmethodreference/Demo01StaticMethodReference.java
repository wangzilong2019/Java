package com.methodreference.demo01.staticmethodreference;

import java.util.Calendar;

/**
 *   通过类名引用静态成员方法
 *   类已经存在，静态成员方法也已经存在
 *   可以通过类名引用静态成员方法
 */
public class Demo01StaticMethodReference {
    //定义一个方法，传递一个参数，另一个参数类型为接口
    public static int method(int num, Calcable c) {
        return c.calAbs(num);
    }

    public static void main(String[] args) {
        //调用方法计算绝对值
        int num = method(-10, (n)-> {
            return Math.abs(n);
        });

        System.out.println(num);

        /**
         *   使用方法优化lambda表达式
         *     Math类是存在的
         *     abs计算绝对值得警惕方法也是存在的
         *     所以可以通过类名调用成员方法
         */
        int num1 = method(-10, Math::abs);
        System.out.println(num1);
    }
}
