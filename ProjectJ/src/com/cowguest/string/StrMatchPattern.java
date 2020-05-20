package com.cowguest.string;

import java.util.Scanner;

public class StrMatchPattern {
    public static void main (String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入俩个字符串:");
        String str = input.next();
        String pattern = input.next();
        System.out.println("匹配结果：" + (new Solution()).match(str.toCharArray(), pattern.toCharArray()));
    }
}

class Solution {

    /**
     *   正则表达式字符串匹配思路
     *     str为待匹配字符串   pattern 为正则表达式
     *     1、求出俩个字符串的长度（考虑递归截至条件）(注意一下循环截至条件 不是  len == 0 而是i == len  包含开头 和结尾)
     *     2、若俩个字符串长度为0时则匹配成功
     *     3、若str不为0且pattern为0时则匹配失败
     *     4、若2、3都不满足时则判断pattern的下一个字符是否为 *
     *         5、若为 * 则判断当前字符是否可以匹配，可以匹配时  （i + 1 && j不变）|| （i不变 && j + 2）
     *           6、不可以匹配则 （i不变 && j + 2）
     *         7、若不为 * 则判断当前字符是否可以匹配，可以匹配时 (i + 1 && j + 1)
     *           8、不可以匹配时则  i不变 j + 1
     *
     *
     * */

    public boolean match(char[] str, char[] pattern) {
        return matchStr(str, 0, pattern, 0);
    }

    public boolean matchStr(char[] str, int i, char[] pattern, int j) {
        //当字符串和匹配字符串长度都为0时匹配成功
        if (str.length == i && pattern.length == j) {
            return true;
        } else if (pattern.length == j) {
            //当字符串不为空，且匹配字符串为空时匹配失败
            return false;
        }

        //找到当前匹配字符的下一个字符,判断是否为 *
        boolean next = ((j + 1  < pattern.length) && pattern[j+1] == '*');

        //当匹配字符串的的下一个字符不是 * 时
        if (!next) {
            //当前位置俩个字符可以匹配
            if ((i < str.length) && (str[i] == pattern[j] || pattern[j] == '.')) {
                //继续匹配
                return matchStr(str, i + 1, pattern, j + 1);
            } else {
                return matchStr(str, i, pattern, j + 1);
            }
        } else {
            //当匹配字符的写一个字符为 * 时
            //当前俩个字符可以匹配
            if ((i < str.length) && (str[i] == pattern[j] || pattern[j] == '.')) {
                return matchStr(str, i, pattern, j + 2) || matchStr(str, i + 1, pattern, j);
            } else {
                return matchStr(str, i, pattern, j + 2);
            }
        }
    }
}
