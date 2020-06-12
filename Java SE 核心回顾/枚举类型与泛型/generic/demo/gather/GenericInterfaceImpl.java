package com.generic.demo.gather;

/**
 *   实现接口泛型的实现类
 * */
public class GenericInterfaceImpl implements GenericInterface<String>{
    @Override
    public void method(String s) {
        System.out.println("输出字符出纳" + s);
    }
}
