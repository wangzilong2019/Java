package leetcode.algorithm.string;

import java.util.Scanner;

public class LongestPalindromeII {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        String s = (new Scanner(System.in)).next();
        System.out.println(solution3.longestPalindrome(s));
    }
}


class Solution3 {

    /**
     *  中心拓展法
     *    因为回文串都是对称的，因为可以从中心位置向俩边拓展
     *    又因为字符串长度有奇数和偶数，所以可以以每个字符  和 俩个字符之间的位置开始拓展 ，且找出最大长度
     * */
    public String longestPalindrome(String s) {
        //当传进去的是空字符串或是长度为0时
        if (s.length() == 0 || s == null) {
            return "";
        }
        int start = 0;
        int end = 0;
        //遍历字符串的每一位开始拓展
        for (int i = 0; i < s.length(); i++) {
            //求在第i为开始拓展的回文串最大长度
            int len1 = expandAroundCenter(s, i, i);
            //求在以 i位 和 i+1位为中心的拓展的长度最大回文串
            int len2 = expandAroundCenter(s, i, i + 1);
            //求出最大长度
            int len = Math.max(len1, len2);
            //和已有的最长回文串比较判断是否需要更新
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        //返回最长回文串
        return s.substring(start, end + 1);
    }

    //求解从left right字串向俩边可拓展的回文串的最大长度
    public int expandAroundCenter(String str, int left, int right) {
        int l = left;
        int r = right;

        //当不越界且当前l和r指针指向的字符相同时，继续拓展
        while (l >= 0 && r < str.length() && str.charAt(l) == str.charAt(r)) {
            l--;
            r++;
        }
        //当不同时跳出循环计算长度
        return r - l - 1;
    }
}