package com.generic.demo.gather;

/**
 *  定义一个含有泛型的类，模拟ArraysList集合
 *     泛型是一个特殊的数据累心，当不知道使用什么数据类型时可以使用泛型
 *     泛型可以接收任意的数据类型
 *     创建的对象的时候定义泛型的数据类型
 *
 * */
public class GenericClass<E> {
    private E name;

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }
}
