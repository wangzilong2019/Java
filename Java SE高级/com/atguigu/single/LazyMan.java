package com.atguigu.single;

import java.lang.reflect.Constructor;

public class LazyMan {
    private LazyMan() {
        synchronized (LazyMan.class) {
            if (lazyMan != null) {
                throw new RuntimeException("不要通过反射破坏异常");
            }
        }
    }

    //volatile 避免指令重排造成lazyMan指向空内存空间
    private volatile static LazyMan lazyMan;

    //双重检测锁模式的懒汉式单例  DCL懒汉式
    public static LazyMan getInstance() {
        if (lazyMan == null) {
            synchronized (LazyMan.class) {
                if (lazyMan == null) {
                    lazyMan = new LazyMan();  //不是一个原子性操作
                    /**
                     *  分配内存空间
                     *  执行构造方法，初始化对象
                     *  把这个对象指向这个空间
                     */
                }
            }
        }
        return lazyMan;
    }

    //反射
    public static void main(String[] args) throws Exception {
        LazyMan instance = LazyMan.getInstance();
        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        LazyMan instance2 = declaredConstructor.newInstance();
        System.out.println(instance);
        System.out.println(instance2);
    }
}
