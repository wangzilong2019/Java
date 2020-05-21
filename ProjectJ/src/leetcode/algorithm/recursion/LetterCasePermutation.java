package leetcode.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public static void main (String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.letterCasePermutation("ab12"));

    }
}

class Solution {
    public List<String> letterCasePermutation(String S) {
        List<StringBuilder> ans = new ArrayList<>();
        ans.add(new StringBuilder());
        for (char c: S.toCharArray()) {
            int n = ans.size();

            if (Character.isLetter(c)) {
                for (int i = 0; i < n; ++i) {
                    System.out.println(ans.get(i));
                    ans.add(new StringBuilder(ans.get(i)));
                    ans.get(i).append(Character.toLowerCase(c));
                    ans.get(n+i).append(Character.toUpperCase(c));
                }
            } else {
                for (int i = 0; i < n; ++i)
                    ans.get(i).append(c);
            }
        }

        List<String> finalans = new ArrayList();
        for (StringBuilder sb: ans)
            finalans.add(sb.toString());
        return finalans;
    }
}
