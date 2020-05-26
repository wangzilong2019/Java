package leetcode.algorithm.string;

import java.util.Scanner;

public class Atoi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        System.out.println((new Atoi()).myAtoi(s));
    }

    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int i = 0;
        //找到第一个非空格字符
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        //没找到
        if (i == str.length()) {
            return 0;
        }
        //判断第一个非空字符时
        boolean flag;
        if (str.charAt(i) == '-') {
            i++;
            flag = false;
        } else if (str.charAt(i) == '+') {
            i++;
            flag = true;
        } else {
            return 0;
        }

        //遍历字符串
        int res = 0;
        //当此字符为数字字符时
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            int digit = str.charAt(i) - '0';
            //判断是否越界
            //  res * 10 + digit > Integer.MAX_VALUE (这里假设为正数)
            if (res > (Integer.MAX_VALUE  - digit) / 10) {
                return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            res = res * 10 + digit;
            i++;
        }
        return flag ? res : -res;
    }
}

