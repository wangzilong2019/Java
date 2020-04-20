package com.guigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MergeSort {
    public static void main (String args[]) {
//        int[] arr = new int[]{9, -3, 2, 6, 7};
//        int[] temp = new int[arr.length];
//        //排序
//        mergeSort(arr, 0, arr.length - 1, temp);
//        System.out.println("排序后的元素为：" + Arrays.toString(arr));

        //测试案例
        int[] a = new int[8000000];
        int[] temp = new int[a.length];
        //向数组中添加元素
        for (int i = 0; i < 8000000; i++) {
            a[i] = (int) (Math.random()*8000000);
        }

        //记录排序前的时间
        Date date1 = new Date();
        //创建格式化字符串
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String curTime = simpleDateFormat.format(date1);
        System.out.println("排序前的时间为：" + curTime);

        //测试归并排序
        mergeSort(a, 0, a.length - 1, temp);

        //记录排序后的时间
        Date date2 = new Date();
        //创建格式化字符串
        String lastTime = simpleDateFormat.format(date2);
        System.out.println("排序前的时间为：" + lastTime);

    }

    //归并排序
    public static void mergeSort (int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //左递归分解
            mergeSort(arr, left, mid, temp);
            //有递归分解
            mergeSort(arr, mid + 1, right, temp);
            //递归排序
            merge(arr, left, mid, right, temp);
        }
    }

    //合并排序算法
    public static void merge (int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;  //左边序列的初始索引
        int j = mid + 1;  //右边序列的初始索引
        int t = 0;
        //先把俩边的有序数组合并到一个数组中
        while (i <= mid && j <= right) {
            //从小大大排序
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }

        //若左边序列剩余
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        //若右边序列剩余
        while (j <= right) {
            temp[t++] = arr[j++];
        }

        //将临时数组中元素赋给原来数组
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft++] = temp[t++];
        }
    }
}
