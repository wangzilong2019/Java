package com.annotation.demo01annotation;

/**
 *   自定义注解
 *   格式：
 *      元注解
 *      public @interface 注解名称(){
 *          属性列表（其实是抽象方法）
 *      }
 *   本质：
 *      注解本质就是一个接口，该接口默认继承Annotation接口
 *   属性：
 *      接口中可以定义的抽象方法
 *      要求：
 *         1、属性的返回值类型
 *             基本数据类型
 *             String
 *             枚举
 *             注解
 *             以上类型的数组
 *         2、定义了属性，在使用时需要给属性赋值
 *            在如果在定义属性时使用default关键字给属性默认初始化则使用注解时，可以不进行属性赋值
 *            如果只有一个属性需要赋值且属性名为value，则value可以省略，直接赋值即可
 *            数组赋值时，值使用大括号，若数组中只有一个元素，则大括号可以省略
 *      元注解：
 *          用来描述注解的注解
 *          @target ：用来描述注解能够作用的位置
 *          @Retention ：描述注解被保留的阶段
 *          @Documented ：描述注解是否被抽取到api文档中
 *          @Inherited ：描述注解是否被子类继承
 */
public @interface MyAnno {
    int age();
    //定义时默认赋值
    String name() default "张三";

    Person per();

    MyAnno2 anno2();

    String[] str();
}
