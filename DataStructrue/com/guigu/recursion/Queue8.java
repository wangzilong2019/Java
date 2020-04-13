package com.guigu.recursion;

public class Queue8 {
    static final int max = 8;
    static int[] x = new int[9];
    static int count = 0;
    public static void main (String args[]) {
        Queue8 queue8 = new Queue8();
        queue8.backtrack(1);
        System.out.println("一共有" + count + "种方法");
    }

    //八皇后回溯算法
    private void backtrack (int t) {
        //当遍历完之后每个皇后都有一个位置记录一个结果
        if (t > max) {
            count++;
            print();
            return;
        }
        //递归回溯算法
        for (int i = 1; i <= max; i++) {
            x[t] = i;//第t个皇后在t行i列
            if (place(t)) {
                backtrack(t+1);//递归
            }
        }
    }

    //判断皇后放置位置是否合适
    private boolean place (int t) {
        //判断第t个皇后与前t-1个是否同行，列或是同斜线
        for (int i = 1; i < t; i++) {
            if (x[i] == x[t] || Math.abs(x[t]-x[i]) == t-i) {
                return false;
            }
        }
        return true;
    }

    //打印皇后位置
    private void print() {
        for (int i = 1; i <= max; i++) {
            System.out.printf("%d ", x[i]);
        }
        System.out.println();
    }
}
