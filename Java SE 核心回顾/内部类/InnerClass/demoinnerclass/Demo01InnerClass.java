package com.InnerClass.demoinnerclass;

import org.w3c.dom.ls.LSOutput;

public class Demo01InnerClass {
    private int a = 10;

    public class InnerClass{
        private int a = 20;

        public void show () {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        Demo01InnerClass demo01InnerClass = new Demo01InnerClass();
        System.out.println(demo01InnerClass.a);

        //创建内部类对象
        Demo01InnerClass.InnerClass innerClass = new Demo01InnerClass().new InnerClass();
        demo01InnerClass.new InnerClass().show();
    }
}
