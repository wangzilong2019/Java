package com.functioninterface.demo01;

/**
 * @Override 注解
 *    作用：
 *        检测方法是否被重写
 *        是：编译成功
 *        否：编译失败
 */
public class MyFunctionalInterfaceImpl implements MyFunctionalInterface{
    @Override
    public void method1() {

    }
}
