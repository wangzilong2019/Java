package com.methodreference.demo01.constructormethodreference;

/**
 *   类的构造器引用
 */
public class Demo {
    //定义一个方法，根据传递字符串返回对象
    public static void printName(String name, PersonBuilder pb) {
        Person person = pb.builderPerson(name);
        System.out.println(person);
    }

    public static void main(String[] args) {
        //调用构造对象的安方法
        printName("张继科", name -> new Person(name));

        /**
         *   使用优化的lambda表达式
         *    构造方法new Person(String name) 已知
         *    创建对象已知
         *    可以使用其创建对象
         */
        printName("马龙", Person::new);  //使用Person类的带参构造方法，通过传递姓名创建对象
    }
}
