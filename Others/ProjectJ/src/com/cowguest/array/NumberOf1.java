package com.cowguest.array;

public class NumberOf1 {
    public static void main (String args[]) {
        System.out.println((new Solution4()).NumberOf1(12));
    }
}

class Solution4 {

    /**
     *  求一个数子二进制表示中1 的个数（如12的二进制 1100）
     *    1、首先将该数字减1 ，该数字变成1011，即从最后一个1开始每个数位取反
     *    2、将原来的二进制与减1后的二进制进行与运算  则从最后一个开始后面所有的数字都为0
     *    3、依次类推知道n为0
     * */

    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n&(n-1);
        }
        return count;
    }
}