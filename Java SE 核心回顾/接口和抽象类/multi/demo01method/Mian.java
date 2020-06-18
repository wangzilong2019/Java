package com.multi.demo01method;

/**
 *    多态中方法调用规则
 *       new 谁 则调用谁的方法，没有则向上找
 *     编译看左边，运行看右边
 *
 *
 * */
public class Mian {
    public static void main(String[] args) {
        //多态
        Fu obj = new Zi();

        obj.show();

        obj.showFu();

        System.out.println(obj.num);
    }
}
