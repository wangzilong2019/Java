package com.guigu.binarysearchrecursion;

public class BinarySearchNoRecursion {
    public static void main (String args[]) {
        int[] arr = {1, 3, 5, 6, 9};
        System.out.println("index = " + binarySearch(arr, 3));

    }

    /**
     *  二分查找非递归
     * @param arr 为带查找数组
     * @param target 为带查找值
     * */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        //二分查找
        while (left <= right) {
            //若找到则直接返回
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {  //向左查找
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        //未找到返回-1
        return -1;
    }
}
