package com.guigu.search;

import java.util.Arrays;

public class FibonacciSearch {
    static final int maxSize = 20;
    public static void main (String args[]) {
        int[] arr = {2, 3, 5, 7, 8};
        int resIndex = fibonacciSearch(arr, 3);
        System.out.println("index = " + resIndex);
    }

    //因为要适用斐波那契数列 mid = low + F(k-1) -1
    //先使用非递归方法生成一个斐波那契数列
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f;
    }

    public static int fibonacciSearch(int[] arr, int findValue) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0;  //表示斐波那契数列下标
        int mid = 0;  //存放mid值
        int[] f = fib();  //获取斐波那契数列
        //获取斐波那契分割数值的下标
        while (high > f[k] - 1) {
            k++;
        }
        //因为f[k]的值可能大于arr的长度，因此要用Arrays类构造一个新的数组，并指向a[]
        //不足的部分会使用0填充
        int[] temp = Arrays.copyOf(arr, f[k]);
        //实际上要使用a数组继续填充temp
        //例：temp = {1, 8, 10, 89, 1000, 1234, 0, 0, 0} => temp = {1, 8, 10, 89, 1000, 1234, 1234, 1234, 1234}
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        //用while循环来处理
        while (low <= high) { //只要这个条件满足，就可以寻找
            mid = low + f[k-1] - 1;
            if (findValue < arr[mid]) {  //这时我们应该向数组左面寻找
                /***
                 *  说明：
                 *     全部元素 = 前面元素 + 后面元素
                 *     f[k] = f[k-1] + f[k-2]
                 *     因为前面有k-1个元素，因此可以继续拆分f[k-1] = f[k-2] + f[k-3]
                 *     即在f[k-1]前面继续查找
                 *     下次循环 mid = f[k-1-1] - 1
                 *
                 */
                high = mid - 1;
                k--;
            } else if (findValue > arr[mid]) {  //此时我们应当向数组右面查找
                /***
                 *  说明：
                 *     全部元素 = 前面元素 + 后面元素
                 *     f[k] = f[k-1] + f[k-2]
                 *     因为前面有k-2个元素，因此可以继续拆分f[k-1] = f[k-3] + f[k-4]
                 *     即在f[k-2]前面继续查找k = k-2
                 *     下次循环 mid = f[k-1-2] - 1
                 *
                 */
                low = mid + 1;
                k = k - 2;
            } else {  //找到
                if (low <= high) {
                    return mid;  //确定返回元素下标
                } else {
                    return high;
                }
            }
        }
        //没有找到，返回-1
        return -1;

    }
}
