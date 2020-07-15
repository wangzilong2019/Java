package com.reflect.demo01reflect;

/**
 *   获取Class对象的方式
 *
 *    - Class.forName("全类名");将字节码加载到内存，返回Class对象
 *    - 类名.class:通过类名的属性class获取
 *     - 对象.getClass()：getClass()方法在Object类中定义
 *
 */
public class Demo01Reflect {
    public static void main(String[] args) throws ClassNotFoundException {
        //1、Class.forName("全类名");将字节码加载到内存，返回Class对象
        Class cl1 = Class.forName("com.reflect.demo01reflect.Person");
        System.out.println(cl1);

        //2、类名.class:通过类名的属性classh获取
        Class cl2 = Person.class;
        System.out.println(cl2);

        //3、对象.getClass()：getClass()方法在Object类中定义
        Person p = new Person();
        Class cl3 = p.getClass();
        System.out.println(cl3);

        //比较三个对象
        System.out.println(cl1==cl2);  //true
        System.out.println(cl2==cl3);  //true
    }
}
