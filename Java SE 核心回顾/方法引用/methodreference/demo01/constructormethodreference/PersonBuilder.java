package com.methodreference.demo01.constructormethodreference;

/**
 *   定义一个创建Person对象的函数式接口
 */
@FunctionalInterface
public interface PersonBuilder {
    //定义一个方法，根据传递的姓名返回对象
    Person builderPerson(String name);
}
