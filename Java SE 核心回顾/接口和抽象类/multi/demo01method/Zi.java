package com.multi.demo01method;

/**
 *   多态的使用调用方法时
 *       当父类和子类有重名方法，new 谁则调用谁的方法
 *
 * */
public class Zi extends Fu {

    //子类中重写父类重名方法
    public void show() {
        System.out.println("子类中重写父类重名方法");
    }


}
