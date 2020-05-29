package leetcode.algorithm.string;

import java.util.Scanner;

public class Problem522II {
    public static void main (String args[]) {
        Solution solution = new Solution();
        String[] strings = new String[3];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            strings[i] = input.next();
        }
        System.out.println(solution.findLUSlength(strings));
    }
}

class Solution {
    public int findLUSlength(String[] strs) {
        int max = -1;
        int j;
        //比较俩个字符串
        for (int i = 0; i < strs.length; i++) {
            for (j = 0; j < strs.length; j++) {
                //当i和j指向同一个字符串或一个字符串是另一个的字传时
                if (i == j ) {
                    continue;
                }

                //若第i个字符串为字符串数组任意字符串则不满足跳出
                if (isSubstring(strs[j], strs[i])) {
                    break;
                }
            }
            if (j == strs.length) {
                max = Math.max(max, strs[i].length());
            }
        }
        return max;
    }

    //判断字符串str2是否为str1的字串
    public boolean isSubstring(String str1, String str2) {
        int j = 0;
        for (int i = 0; i < str1.length() && j < str2.length(); i++) {
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
        }
        return j == str2.length();
    }
}
