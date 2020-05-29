package com.cowguest.array;

public class JumpFloorII {
    public static void main (String args[]) {
        System.out.println((new Solution2().JumpFloorII(3)));
    }
}

class Solution2 {
    public int JumpFloorII(int target) {
        return 1 << (target - 1);
    }
}