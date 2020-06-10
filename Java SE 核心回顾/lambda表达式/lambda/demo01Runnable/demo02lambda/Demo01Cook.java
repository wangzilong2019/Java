package com.lambda.demo01Runnable.demo02lambda;

public class Demo01Cook {
    public static void main(String[] args) {
        //调用invoke方法，参数使Cook接口，传递Cook接口的内部类对象
        invokeCook(new Cook() {
            @Override
            public void mackFood() {
                System.out.println("吃饭了");
            }
        });

        //使用lambda表达式创建
        invokeCook(()->{
            System.out.println("吃饭了lambda表达式");
        });
    }

    //定义一个方法，参数传递Cook接口，方法内部调用Cokk接口中的mackFood()啊方法
    public static void invokeCook(Cook cook) {
        cook.mackFood();
    }
}
