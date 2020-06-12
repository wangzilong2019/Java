package com.generic.demo.gather;

public class DemoGenericMethod {
    public static void main(String[] args) {
        //创建对象
        GenericMethod gm = new GenericMethod();

        /**
         * 调用含有泛型的方法，传递什么类型，泛型就是什么类型
         * */
        gm.method(1);
        gm.method("ddd");
        gm.method(6.6);

        /**
         * 调用静态方法，不建议使用对象调用
         * */
        GenericMethod.method2("11");
    }
}
