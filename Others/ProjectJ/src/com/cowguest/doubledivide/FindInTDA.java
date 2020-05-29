package com.cowguest.doubledivide;

import java.util.Arrays;

public class FindInTDA {
    public static void main (String args[]) {
        int[] arr = {0, 10, 89, 1000};
        int index = Arrays.binarySearch(arr, 9);
        System.out.println(index);
    }
}

class Solution {
    public boolean Find2(int target, int [][] array) {
        //我的理解覆盖式查找法
        int row = array.length;
        int col = array[0].length;
        //查找数组中元素
        for (int i = row - 1, j = 0; i >= 0 && j < col;) {
            //查找到时直接返回
            if (target == array[i][j]) {
                return true;
            } else if (target < array[i][j]) {
                i--;
                continue;
            } else {
                j++;
                continue;
            }
        }
        //查找不到返回
        return false;
    }

    public boolean Find(int target, int [][] array) {
        //通过对每一行的元素二分查找
        for (int[] x : array) {
            if (findINDouble(x, 0, x.length - 1, target)) {
                return true;
            }
        }
        //没找到
        return false;
    }

    public boolean findINDouble(int a[], int low, int high, int target) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == a[mid]) {
                return true;
            } else if (target < a[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        //没找到返回false
        return false;
    }
}