package com.interfacetest.defaultmethod.privatemethod;

/**
 *   为了更符号常理
 *      当有几个方法公用同一段代码时，将其抽取出来作为共有方法，使得在实现类中不能随意调用
 * */
public interface DemoPrivateMethod {
    public default void show1() {
        System.out.println("接口中调用方法1");
        showCommon();
    }

    public default void show2() {
        System.out.println("接口中调用方法2");
        showCommon();
    }

    //定义私有方法
    private void showCommon() {
        System.out.println("共有代码");
    }

    public static void show3() {
        System.out.println("接口中调用方法1");
        showCommon2();
    }

    public static void show4() {
        System.out.println("接口中调用方法2");
        showCommon2();
    }

    //定义私有方法
    private static void showCommon2() {
        System.out.println("共有代码");
    }

}
