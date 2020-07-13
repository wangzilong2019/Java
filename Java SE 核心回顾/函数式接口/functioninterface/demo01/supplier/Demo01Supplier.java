package com.functioninterface.demo01.supplier;

import java.util.function.Supplier;

/**
 *   常用函数式接口
 *       java.util.function.Supplier 接口中仅包含一个无参的方法： T get().用来获取一个泛型类型指定的参数对象数据
 *       Supplier被称为生产型接口，指定接口的泛型是什么类型，那么接口中的get方法就会返回一个什么类型的数据
 *
 */
public class Demo01Supplier {
    /**
     *  定义一个方法，参数传递为接口类型
     */
    public static String getString(Supplier<String> sup) {
        return sup.get();
    }

    public static void main(String[] args) {
        //调用方法，因为方法参数是一个函数式接口，以此可以传递lambda表达式
        String s = getString(()->"好还有");
        System.out.println(s);
    }
}
