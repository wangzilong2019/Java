package com.interfacetest.defaultmethod;

public interface Car {

    public abstract void show();

    //定义一个默认方法，可以解决接口升级问题
    public default void showDefault() {
        System.out.println("调用了接口中的默认方法");
    }
}
