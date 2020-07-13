package com.functioninterface.demo01;

/**
 *    函数式接口：有且仅有一个抽象方法，称为函数式接口
 *                当然可以有其它方法（默认方法，静态、私有等）
 *    @FunctionalInterface 作用
 *        检测接口是否是一个函数式接口
 *        是：编译成功
 *        否：编译失败（接口中的抽象方法不是一个）
 */

public interface MyFunctionalInterface {
    public abstract void method1();

    //void method2();
}
