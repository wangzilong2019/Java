package com.cowguest.array;

public class JumpFloor {
    public static void main (String args[]) {
        System.out.println((new Solution1().jumpFloor(4)));
    }
}

class Solution1 {
    public int jumpFloor(int target) {
        int s1, s2;
        if (target == 1 || target == 2) {
            return target;
        }
        s1 = 1;
        s2 = 2;
        for (int i = 3; i <= target; i++) {
            s2 = s1 + s2;
            s1 = s2 - s1;
        }
        return s2;
    }
}