package com.methodreference.demo01.supermethodreference;

/**
 * 定义子类
 */
public class Man extends Human {
    //子类重写父类方法

    @Override
    public void sayHello() {
        System.out.println("hello 我是man");
    }

    //定义一个方法传递Greetable接口
    public void method(Greetable g) {
        g.greet();
    }

    public void show() {
        //调用method方法
        method(()-> {
            //创建父类对象
            Human h = new Human();
            //调用父类方法
            h.sayHello();
        });

        //因为有子父类，所以存在一个关键字，代表父类，可以直接使用super调用父类的成员方法
        method(()-> {
            super.sayHello();
        });

        /**
         *   使用super引用父类的成员方法
         *   super已经存在
         *   父类的成员方法sayHello已经存在
         *   所以可以直接使用super引用父类的成员方法
         */
        method(super::sayHello);
    }

    public static void main(String[] args) {
        new Man().show();
    }
}
