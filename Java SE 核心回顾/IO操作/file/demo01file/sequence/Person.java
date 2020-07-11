package com.file.demo01file.sequence;

import java.io.Serializable;

/**
 *    序列化和反序列化都会抛出 NotSerializableException  没有序列化异常
 *       类通过实现 Serializable 接口以启用其序列化功能，来实现此接口的类将无法使用任何序列化或反序列化
 *       Serializable类型接口也称为标记类型接口
 *          要进行序列化和反序列化的类必须实现 Serializable 接口，就会给类添加一个标记
 *          当我们进行序列化和反序列化的时候，就会检测类上是否有这个异常
 *              有：可以序列化和反序列化
 *              没有：则抛出 异常
 *        去市场买肉-》肉上有一个蓝色章（检测合格）-》放心购买-》买回来随意吃
 */
public class Person implements Serializable {
    //定义一个序列号，当执行反序列化操作时，Person类中name和age的值，而反序列化操作输出的还是原值
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}