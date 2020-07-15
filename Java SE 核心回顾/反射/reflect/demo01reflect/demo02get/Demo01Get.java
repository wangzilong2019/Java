package com.reflect.demo01reflect.demo02get;


import com.reflect.demo01reflect.Person;

import java.io.FileInputStream;
import java.lang.reflect.Field;

/**
 *   获取功能
 *      1、获取成员变量
 *           Field getField(String name)
 *              返回一个 Field 对象，它反映此 Class 对象所表示的类或接口的指定公共成员字段。
 *           Field[] getFields()
 *               返回一个包含某些 Field 对象的数组，这些对象反映此 Class 对象所表示的类或接口的所有可访问公共字段。
 *           Field getDeclaredField(String name)
 *               返回一个 Field 对象，该对象反映此 Class 对象所表示的类或接口的指定已声明字段。
 *           Field[] getDeclaredFields()
 *               返回 Field 对象的一个数组，这些对象反映此 Class 对象所表示的类或接口所声明的所有字段。
 *      2、获取构造方法
 *            Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)
 *               返回一个 Constructor 对象，该对象反映此 Class 对象所表示的类或接口的指定构造方法。
 *            Constructor<?>[] getDeclaredConstructors()
 *               返回 Constructor 对象的一个数组，这些对象反映此 Class 对象表示的类声明的所有构造方法。
 *             Constructor<T> getConstructor(Class<?>... parameterTypes)
 *               返回一个 Constructor 对象，它反映此 Class 对象所表示的类的指定公共构造方法。
 *            Constructor<?>[] getConstructors()
 *              返回一个包含某些 Constructor 对象的数组，这些对象反映此 Class 对象所表示的类的所有公共构造方法。
 *      3、获取成员方法
 *            Field getDeclaredField(String name)
 *              返回一个 Field 对象，该对象反映此 Class 对象所表示的类或接口的指定已声明字段。
 *            Field[] getDeclaredFields()
 *                返回 Field 对象的一个数组，这些对象反映此 Class 对象所表示的类或接口所声明的所有字段。
 *             Method getMethod(String name, Class<?>... parameterTypes)
 *              返回一个 Method 对象，它反映此 Class 对象所表示的类或接口的指定公共成员方法。
 *           Method[] getMethods()
 *              返回一个包含某些 Method 对象的数组，这些对象反映此 Class 对象所表示的类或接口
 *              （包括那些由该类或接口声明的以及从超类和超接口继承的那些的类或接口）的公共 member 方法。
 *      4、获取类名
 *          String getName()
 *           以 String 的形式返回此 Class 对象所表示的实体（类、接口、数组类、基本类型或 void）名称。
 */
public class Demo01Get {
    public static void main(String[] args) throws Exception {
        //获取Person的Class对象
        Class personClass = Person.class;

        //1、Field[] getFields() 获取所有的public修饰的成员变量
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("============");

        //2、Field getField(String name)
        Field a = personClass.getField("a");
        //获取成员变量a的值
        Person p = new Person();
        Object value = a.get(p);
        //设置a的值
        a.set(p, "张三");
        System.out.println(p);
        System.out.println("==============");

        //3、Field[] getDeclaredFields()
        //获取所有的成员变量
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
        }

        //4、Field getDeclaredField(String name)
        Field d = personClass.getDeclaredField("d");
        //因为d是私有变量，若要访问要忽略访问权限修饰符的安全检查
        d.setAccessible(true);  //暴力fan'she
        Object value2 = d.get(p);
        System.out.println(value2);
    }
}
