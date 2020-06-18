package com.multi.demo02field;

/**
 *   多态成员变量的使用
 *       只有方法可以重写，成员便令不可以重写
 *       1、直接通过对象名称访问成员变量，看等号左面是谁，优先使用谁，没有则想上找
 *       2、间接通过成员方法访问成员变量，看方法属于谁，优先用谁，没有则想上找
 * */
public class MutiField {
    public static void main(String[] args) {
        Fu obj = new Zi();

        System.out.println(obj.num);  //10
        obj.shouNum();  //5
    }
}
