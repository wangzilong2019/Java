package com.methodreference.demo01.thismethodreference;

/**
 *   通过this引用本类的成员方法
 */
public class Husband {
    //定义一个买房子的方法
    public void buyHouse() {
        System.out.println("北京二环内每一套四合院");
    }

    //定义一个结婚方法，传递Richable接口
    public void marry(Richable r) {
        r.buy();
    }

    //定义一个非常高兴的方法
    public void soHappy() {
        //调用结婚的方法，参数传递一个lambda表达式
        marry(()-> {
            //调用本类的成员方法
            this.buyHouse();
        });

        /**
         *   使用方法引用优化lambda表达式
         *   this存在
         *   本类成员方法也存在
         *   所以可以通过this引用本类的成员方法
         */
        marry(this::soHappy);
    }

    public static void main(String[] args) {
        new Husband().soHappy();
    }
}
