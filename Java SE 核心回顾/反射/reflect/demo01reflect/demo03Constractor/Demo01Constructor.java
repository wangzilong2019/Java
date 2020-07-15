package com.reflect.demo01reflect.demo03Constractor;

import com.reflect.demo01reflect.Person;

import java.lang.reflect.Constructor;

/**
 *   获取构造器
 *
 *    *      2、获取构造方法
 *  *            Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)
 *  *               返回一个 Constructor 对象，该对象反映此 Class 对象所表示的类或接口的指定构造方法。
 *  *            Constructor<?>[] getDeclaredConstructors()
 *  *               返回 Constructor 对象的一个数组，这些对象反映此 Class 对象表示的类声明的所有构造方法。
 *  *             Constructor<T> getConstructor(Class<?>... parameterTypes)
 *  *               返回一个 Constructor 对象，它反映此 Class 对象所表示的类的指定公共构造方法。
 *  *            Constructor<?>[] getConstructors()
 *  *              返回一个包含某些 Constructor 对象的数组，这些对象反映此 Class 对象所表示的类的所有公共构造方法。
 */
public class Demo01Constructor {
    public static void main(String[] args) throws Exception {
        //获取Person的Class对象
        Class personClass = Person.class;

        //Constructor<T> getConstructor(Class<?>... parameterTypes)
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor);
        //创建对象
        Object person = constructor.newInstance("小狗", 10);
        System.out.println(person);

        //创建空参数构造方法
        Constructor constructor1 = personClass.getConstructor();
        System.out.println(constructor1);
        //床架对象
        Object person1 = constructor1.newInstance();
        System.out.println(person1);

        /**
         *  优化创建空参构造方法
         */
        Object o = personClass.newInstance();
        System.out.println(o);
    }
}
