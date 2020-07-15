package com.reflect.demo01reflect.demo05reflecttest;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 *   框架类：
 *     在不改变任何类的前提下，可以创建任意类对象，执行任意方法
 */
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        //可以创建任意类对象，执行任意方法

        /**
         *   前提：可以创建任意类对象，执行任意类方法
         */

        //1、加载配置文件
        //创建Properties对象
        Properties properties = new Properties();
        //加载配置文件，转换为一个集合
        //获取class目录下的配置文件
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("pro.properties");
        properties.load(is);

        //2、获取配置文件中配置的数据
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");

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
