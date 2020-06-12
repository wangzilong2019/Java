package com.generic.demo.gather;

/**
 *  测试带有泛型接口的实现类
 * */
public class DemoGenericInterface {
    public static void main(String[] args) {
        //创建带有泛型接口的实现类对象
        GenericInterfaceImpl gii = new GenericInterfaceImpl();
        gii.method("小狗");

        //第二种方式创建带有泛型的接口实现类对象
        GenericInterfaceImpl2<Integer> gii2 = new GenericInterfaceImpl2<>();
        gii2.method(3);
    }
}
