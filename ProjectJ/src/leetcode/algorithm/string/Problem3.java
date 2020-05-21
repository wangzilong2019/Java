package leetcode.algorithm.string;

import java.util.HashSet;
import java.util.Set;

public class Problem3 {
}

class Solution1 {
    /**
     *  思路：
     *    因为最长字串是连续的，所以每个以第i个字符开头的字符串都有字串
     *    起始位置为第i个字符，若第rk+1的字符与已经加入的不重复，则加入，否则就是以第i个字符开始的最大字串
     *    以第i开始的字符的字串查找完毕，则i++ 下一个开始知道结束
     *
     * */

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int rk = -1;
        int n = s.length();
        //哈希集合，判断每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        //以每个字符串起始字符遍历查找
        for (int i = 0; i < s.length(); i++) {
            //每次向右除去一个起始字符
            if (i != 0) {
                occ.remove(s.charAt(i-1));
            }

            //向右遍历查找最长不重复字串
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                occ.add(s.charAt(rk + 1));
                rk++;
            }
            res = Math.max(res, rk - i + 1);
        }
        return res;
    }
}