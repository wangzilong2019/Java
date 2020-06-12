package com.generic.demo.gather;

public class DemoGenericClass {
    public static void main(String[] args) {
        //不写泛型默认为Object类型
        GenericClass gc = new GenericClass();
        gc.setName("这是使用字符串变量");
        System.out.println(gc.getName());

        //使用String类型
        GenericClass<String> gc2 = new GenericClass<>();
        gc2.setName("字符串");
        System.out.println(gc2.getName());

        //使用Integer类型
        GenericClass<Integer> gc3 = new GenericClass<>();
        gc3.setName(1);
        System.out.println(gc3.getName());
    }
}
