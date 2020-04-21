package search;

import java.util.Arrays;

public class FibonacciSearch {
    static final int maxSize = 20;
    public static void main (String args[]) {

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


    }
}
