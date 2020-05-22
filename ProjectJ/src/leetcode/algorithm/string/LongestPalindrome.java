package leetcode.algorithm.string;

import java.util.Scanner;

public class LongestPalindrome {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        Scanner input = new Scanner(System.in);
        String s = input.next();
        System.out.println(solution2.longestPalindrome(s));
    }
}

class Solution2 {

    /**
     *  动态规划求解最长回文串
     *   思路：
     *     利用思想 当 i 到 j个字符串为回文串时，则 i+1 到 j-1个字符串必定为回文串（限制条件 j-i > 2）
     *     由此可以从后往前遍历  每次 i到j个字符为字符串时则更新
    * */


    public String longestPalindrome(String s) {
        //用来存放当前最长公共字串
        String res = "";
        //记录串的长度
        int len = s.length();
        boolean dp[][] = new boolean[len][len]; //用来存放第i到j个字符串是否为回文串
        //因为地推公式  dp[i][j] = dp[i+1][j-1] && si == sj 所以若要知道第i个字符首先要知道i+1  所以逆序
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                // j - i < 2 是当一个或是俩个字符时判断是否为   dp[i+1][j-1]是用来判断多个字符
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i < 2 || dp[i+1][j-1]);
                //当前最长回文串大于已有的 更新记录
                if (dp[i][j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}