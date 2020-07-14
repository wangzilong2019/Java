package com.methodreference.demo01.objectmethodreference;

import com.thread.demo12waitandnotify.Demo;

/**
 *   通过对象来引用成员方法
 *   前提是对象名已经存在，成员方法已经存在
 */
public class Demo01ObjectMethodReference {
    public static void printString(Printable p) {
        p.print("hello");
    }

    public static void main(String[] args) {
        //调用上述方法，传递一个lambda表达式
        printString((s)-> {
            //创建一个MethodObject对象
            Demo01MethodObject obj = new Demo01MethodObject();
            //调用成员方法，按照大写输出
            obj.printUpperCaseString(s);
        });

        /**
         *   方法优化
         *      对象存在
         *      成员方法存在
         *      所以可以通过对象名引用成员方法
         */
        Demo01MethodObject obj = new Demo01MethodObject();
        printString(obj::printUpperCaseString);
    }
}
