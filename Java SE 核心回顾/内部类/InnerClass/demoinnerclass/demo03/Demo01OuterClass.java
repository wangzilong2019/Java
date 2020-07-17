package com.InnerClass.demoinnerclass.demo03;

public class Demo01OuterClass {
    public void outerMethod() {
        class InnerClass {
            int num = 10;
            public void innerMethod() {
                System.out.println(num);
            }
        }
        //调用方法
        new InnerClass().innerMethod();
    }

    public static void main(String[] args) {
        //创建外部类对象调用成员方法
        Demo01OuterClass demo01OuterClass = new Demo01OuterClass();
        demo01OuterClass.outerMethod();
    }
}
