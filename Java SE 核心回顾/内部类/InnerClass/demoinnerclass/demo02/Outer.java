package com.InnerClass.demoinnerclass.demo02;

public class Outer {
    int num = 10;

    public class Inner{
        int num = 20;

        public void innerMethod() {
            //访问内部类成员变量
            System.out.println(num);
            System.out.println(this.num);

            //访问外部类成员变量
            System.out.println(Outer.this.num);
        }
    }

    public static void main(String[] args) {
        //创建内部类对象
        Outer.Inner inner = new Outer().new Inner();
        inner.innerMethod();
    }
}
