package leetcode.algorithm.string;

import java.util.HashSet;
import java.util.Set;

public class CanPermutePalindrome {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        //将字符串转换为字符数组
        char[] chars = s.toCharArray();
        //创建一个HashSet集合
        Set<Character> hashSet = new HashSet<Character>();
        /**
         *
         遍历字符串，当集合中没有此字符时加入集合，再次出现时去除
         若为回文串，当字符串长度位偶数时只允许有集合中元素 个数 = 0 即 元素必须成对出现
         若回文串的长度位奇数，仅允许有一个元素不同
         *
         * */
        for (Character ch : chars) {
            //当hashSet集合中再次出现时去除
            if (hashSet.contains(ch)) {
                hashSet.remove(ch);
            } else {
                //第一次出现时加入
                hashSet.add(ch);
            }
        }

        //返回hashSet集合长度
        return hashSet.size() <= 1;
    }
}
