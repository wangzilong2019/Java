package com.cowguest.array;

public class Fibonacci {
    public static void main (String args[]) {
        System.out.println((new Solution().Fibonacci(4)));
    }
}

class Solution {
    public int Fibonacci(int n) {
        int s1, s2;
        //判断n的值
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }
        s1 = 1;
        s2 = 1;
        for (int i = 3; i <= n; i++) {
            s2 = s1 + s2;
            s1 = s2 - s1;
        }
        return s2;
    }
}