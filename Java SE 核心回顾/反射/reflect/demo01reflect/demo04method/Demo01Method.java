package com.reflect.demo01reflect.demo04method;


import com.reflect.demo01reflect.Person;

import java.lang.reflect.Method;

/**
 *    *      3、获取成员方法
 *  *            Field getDeclaredField(String name)
 *  *              返回一个 Field 对象，该对象反映此 Class 对象所表示的类或接口的指定已声明字段。
 *  *            Field[] getDeclaredFields()
 *  *                返回 Field 对象的一个数组，这些对象反映此 Class 对象所表示的类或接口所声明的所有字段。
 *  *             Method getMethod(String name, Class<?>... parameterTypes)
 *  *              返回一个 Method 对象，它反映此 Class 对象所表示的类或接口的指定公共成员方法。
 *  *           Method[] getMethods()
 *  *              返回一个包含某些 Method 对象的数组，这些对象反映此 Class 对象所表示的类或接口
 *  *              （包括那些由该类或接口声明的以及从超类和超接口继承的那些的类或接口）的公共 member 方法。
 *
 *           执行方法
 *             Object invoke(Object obj, Object...args)
 *            获取方法名称
 *            String getName
 */
public class Demo01Method {
    public static void main(String[] args) throws Exception {
        //获取Class对象
        Class personClass = Person.class;

        /**
         *   通过方法名和参数列表获取方法
         */
        //获取指定名称的方法
        Method eat_method = personClass.getMethod("eat");
        Person p = new Person();
        //执行方法
        eat_method.invoke(p);

        Method eat_method2 = personClass.getMethod("eat", String.class);
        eat_method2.invoke(p, "狗肉");
        System.out.println("=================");

        //获取所有public修饰的方法
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
            String name = method.getName();
            System.out.println(name);
        }

        //同样支持暴力反射
        //method.setAccessible(true);

        //获取类名
        String className = personClass.getName();
        System.out.println(className);

    }

}
