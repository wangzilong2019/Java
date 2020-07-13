package com.functioninterface.demo01;

/**
 *   函数式接口的使用：一般可以作为方法的参数和返回值类型
 *
 */
public class Demo01 {
    /**
     *   定义一个方法，参数使用函数式接口
     */
    public static void show (MyFunctionalInterface myInter) {
        myInter.method1();
    }

    public static void main(String[] args) {
        //调用show方法，方法参数是一个接口，所以可以穿衣一个实现类对象
        show(new MyFunctionalInterfaceImpl());

        //调用show方法，使用匿名内部类
        show(new MyFunctionalInterface() {
            @Override
            public void method1() {
                System.out.println("使用匿名内部类重写接口中的抽象方法");
            }
        });

        //使用lambda表达式重写
        show(()-> System.out.println("使用lamda表达式重写抽象方法"));
    }
}
