package leetcode.algorithm.dp;

import java.util.Arrays;
import java.util.Scanner;

public class MaxLcsl {
    public static void main (String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入俩个字符串str1和str2：");
        String str1 = input.next();
        String str2 = input.next();
        LCSL lcsl = new LCSL(str1, str2);
        //调用方法求最长公共子序列
        lcsl.maxLcsl();
        System.out.println("最长公共子序列长度为：" + lcsl.c[lcsl.len1][lcsl.len2]);
        System.out.println("最长公共子序列为：");
        lcsl.prints(lcsl.len1, lcsl.len2);
        for (int[] x : lcsl.c) {
            System.out.println(Arrays.toString(x));
        }

    }
}

class LCSL {
    int[][] c;  //存放字符串长度
    int[][] b;
    int len1;  //第一个字符串长度
    int len2;  //第二个字符串长度
    String str1;
    String str2;

    public LCSL(String str1, String str2) {
        //求俩个字符串长度
        len1 = str1.length();
        len2 = str2.length();
        c = new int[len1+1][len2+1];
        b = new int[len1+1][len2+1];
        this.str1 = str1;
        this.str2 = str2;
        //对矩阵初始化
        for (int i = 0; i <= len1; i++) {
            c[i][0] = 0;
        }
        for (int j = 0; j <= len2; j++) {
            c[0][j] = 0;
        }
    }

    public void maxLcsl() {
        //遍历字符串查找最长公共子序列
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                //判断当前字符是否相同
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    c[i][j] = c[i-1][j-1];
                    //记录来源
                    b[i][j] = 1;
                } else if (c[i][j - 1] >= c[i-1][j]) {
                    c[i][j] = c[i][j-1];
                    b[i][j] = 2;
                } else {
                    c[i][j] = c[i-1][j];
                    b[i][j] = 3;
                }
            }
        }
    }

    //打印最优解
    public void prints(int i, int j) {
        if (i == 0 || j == 0) {
            return;
        }
        if (b[i][j] == 1) {
            prints(i-1, j-1);
            System.out.printf("%c",str1.charAt(i-1));
        } else if (b[i][j] == 2) {
            prints(i, j-1);
        } else {
            prints(i-1, j);
        }
    }
}