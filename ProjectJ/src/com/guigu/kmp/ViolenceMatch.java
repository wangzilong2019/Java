package com.guigu.kmp;

public class ViolenceMatch {
    public static void main (String args[]) {
        int matchIndex = violenceMatch("abcde", "cd");
        System.out.println("matchIndex = " + matchIndex);
    }

    //暴力算法匹配字符串
    public static int violenceMatch(String str1, String str2) {
        //将字符串转换为字符数组
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        //计算字符串长度
        int s1len = s1.length;
        int s2len = s2.length;
        int i = 0;  //指向s1字符串左部起始位置
        int j = 0;  //指向s2字符串起始位置
        while (i < s1len && j < s2len) {
            if (s1[i] == s2[j]) { //匹配
                i++;
                j++;
            } else {  //不匹配
                i = i - j + 1;
                j = 0;
            }
        }

        //判断是否匹配成功
        if (s2len == j) {
            return i - j;
        } else {
            return -1;
        }
    }

}
