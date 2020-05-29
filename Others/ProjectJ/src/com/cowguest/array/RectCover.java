package com.cowguest.array;

public class RectCover {
    public static void main (String args[]) {
        System.out.println((new Solution3().RectCover(3)));
    }
}

class Solution3 {
    public int RectCover(int target) {
        if (target <= 1) {
            return 1;
        }else if (target == 2) {
            return 2;
        } else {
            return RectCover(target - 1) + RectCover(target - 2);
        }
    }
}