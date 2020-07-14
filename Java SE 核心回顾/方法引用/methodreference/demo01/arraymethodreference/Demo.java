package com.methodreference.demo01.arraymethodreference;

/**
 *   数组的构造器引用
 */
public class Demo {
    /**
     *   定义一个方法
     *   方法参数传递创建数组的长度和Arraybuilder接口
     */
    public static int[] createArray(int length, ArrayBuilder ab) {
        return ab.builderArray(length);
    }

    public static void main(String[] args) {
        //调用上述方法创建数组
        int[] arr = createArray(10, (len)-> new int[len]);
        System.out.println(arr.length);
        /**
         *  使用lambda表达式优化
         *  已知创建的是int[]数组
         *  数组的长度已知
         *  可以使用方法引用来创建数组
         */
        int[] arr2 = createArray(20,int[]::new);
        System.out.println(arr2.length);
    }
}
