package com.methodreference.demo01;

import com.methodreference.demo01.objectmethodreference.Printable;

/**
 *
 */
public class Demo01Printable {
    /**
     *  定义一个方法，传递Printable接口，对字符串打印
     */
    public static void printString(Printable p) {
        p.print("hello");
    }

    public static void main(String[] args) {
        //调用printable方法，传递lambda表达式
        printString(s-> System.out.println(s));

        /**
         *   分析：
         *      lambda表达式目的：打印参数传递的字符串
         *      把参数s传递给了System.out对象，调用out方法中的println对字符串输出
         *      注意：
         *         System.out 对象是已经存在的
         *         println 方法也是存在的
         *         所以可以直接使用System.out方法直接引用println方法
         *         :: 被称为方法引用运算符，而它所在的表达式被称为方法引用
         *         如果lambda要表达的函数方案已经存在于某个方法的实现中，那么可以通过::来引用该方法作为lambda表达式的替代者
         *      区别：
         *         第一种lambda语义：拿到参数之后经过lambda表达式之手，进而传递给System.out.println方法去处理
         *         第二种语义，直接让System.out的println方法去替代lambda表达式
         *         注意：lambda中传递的参数一定是方法引用中那个方法可以接受的类型，否则会抛出异常
         */
        printString(System.out::println);
    }
}
