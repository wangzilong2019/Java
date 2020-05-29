package leetcode.algorithm.string;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseWords151 {
    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        System.out.println(solution7.reverseWords(s));
    }
}

class Solution7 {

    /**
     *   算法思想：
     *      1、分割
     *      2、反转
     *      3、合并
     * */
    public String reverseWords(String s) {
        //首先去除字符串首尾空格，这里不可以使用trim()方法去除空格
        int left = 0;
        int right = s.length() - 1;
        StringBuilder sb = new StringBuilder(s);

        //找到左右第一个非空格字符
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }

        //得到去除左右空格后的字符串
        s = sb.substring(left, right + 1).toString();
        //将字符串以空格作为分隔符分割 "+" 代表一个或是多个空格
        String[] splitStr = s.split("\\s+");

        sb = new StringBuilder();
        //生成新字符串
        for (int i = splitStr.length - 1; i >= 0; i--) {
            //当最后一个字符串时不添加空格
            if (i == 0) {
                sb.append(splitStr[i]);
            } else {
                //当不是最后一个字符串时加 空格
                sb.append(splitStr[i] + " ");
            }
        }
        return sb.toString();
    }
}