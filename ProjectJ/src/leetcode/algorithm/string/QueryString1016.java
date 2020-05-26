package leetcode.algorithm.string;

public class QueryString1016 {
    /**
     *   本题思路：
     *      先将数字1-n转换为二进制字符串，判断字符串s是否包含
     * */
    public boolean queryString(String S, int N) {
        if (S == null || S.length() == 0) {
            return false;
        }

        //遍历数字1-N将其转换为二进制字符串
        for (int i = 1; i <= N; i++) {
            //判断S是否包含i的二进制字符串
            if (!S.contains(Integer.toBinaryString(i))) {
                return false;
            }
        }
        return true;
    }
}
