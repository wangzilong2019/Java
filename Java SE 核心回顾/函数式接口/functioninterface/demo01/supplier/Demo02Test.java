package com.functioninterface.demo01.supplier;

import java.util.function.Supplier;

/**
 *   练习：求数组元素的最大值
 *       使用Supplier接口作为方法参数类型，通过lambda表达式求出最大值
 *
 */
public class Demo02Test {
    /**
     *  定义一个方法，返回数组元素的最大值方法参数传递Supplier类型接口
     */
    public static int getMax(Supplier<Integer> sup) {
        return sup.get();
    }

    public static void main(String[] args) {
        int[] arr = {6, 4, 2, 1, 78};
        int maxValue = getMax(()-> {
                int max = arr[0];
                for (int e : arr) {
                    if (e > max) {
                        max = e;
                    }
                }
                return max;
            }
        );

        System.out.println(maxValue);
    }
}
