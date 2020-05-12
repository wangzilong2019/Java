package com.guigu.kmp;

import java.util.Arrays;

public class KmpMatch {
    public static void main (String args[]) {
//        String str = "AA";
//        int[] a = kmpNext(str);
//        System.out.println(Arrays.toString(a));
        String str1 = "ADVFGH GFG";
        String str2 = "H G";
        int index = kmpSearch(str1, str2, kmpNext(str2));
        System.out.println("index = " + index);

    }

    /** KMP算法思想
     *    Kmp算法就是利用之前判断过的信息，通过一个next数组，保存模式串中最长公共子序列的长度，每次回溯时，通过next数组找到
     *    前面匹配过的位置，省去了大量的时间
     *    移动位数 = 已匹配的字符数 - 对应的部分匹配值
     *    部分匹配值就是 前缀和后缀最长的共有元素的长度(即前缀元素前缀集合和后缀集合相同的元素 例如 a 和 ac 为0 ad 和 ad 为2)
     *    "bread"  前缀 b, br, bre, brea;  后缀：d, ad, ead, read
     *    先得到字串的部分匹配表
     *    再利用部分匹配表完成字符串匹配
     *
     * */

    /**
     * @param str1 源字符串
     * @param str2 待匹配字串
     * @param next 字符串匹配表
     *
     * */
    public static int kmpSearch(String str1, String str2, int[] next) {
        for (int i = 0, j = 0; i < str1.length(); i++) {
            //当俩个字符不相等的时候处理
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }

            //当俩个子字符相同时
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            //找到了返回下标
            if (j == str2.length()) {
                return i - j + 1;
            }
        }
        //没有找到
        return -1;
    }


    //获取子字符串的部分匹配表
    public static int[] kmpNext(String str) {
        //创建一个数组来存放部分匹配表的值
        int[] next = new int[str.length()];
        //当字符串长度为1时，字符匹配表为0
        next[0] = 0;
        //计算部分匹配表的值
        for (int i = 1, j = 0; i < str.length(); i++) {
            //当俩个字符不相等的时候需要从next[j-1]获取j
            //知道有俩个字符相等才退出
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = next[j - 1];
            }

            //当有字符相等时匹配+ 1
            if (str.charAt(i) == str.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
