package com.annotation.demo01annotation.test;

import java.lang.reflect.Method;

@Pro(className = "com.annotation.demo01annotation.test.Demo01", methodName = "show")
public class ReflectTest {
    public static void main(String[] args) throws Exception{
        //1、解析注释
        //1.1获取该类的字节码文件对象
        Class<ReflectTest> reflectTestClass = ReflectTest.class;
        //2、获取上边的注解对象
        Pro an = reflectTestClass.getAnnotation(Pro.class);

        //3、调用注解对象中调用的方法，并获取返回值
        String className = an.className();
        String methodName = an.methodName();

        System.out.println(className);
        System.out.println(methodName);



        //3、加载该类进入内存
        Class cls = Class.forName(className);
        //4、创建对象
        Object obj = cls.newInstance();
        //5、获取对象方法
        Method method = cls.getMethod(methodName);
        //执行方法
        method.invoke(obj);
    }
}
