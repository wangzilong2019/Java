package com.guigu.sort;

import javax.management.ValueExp;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {
    public static void main (String args[]) {
//        int[] arr = {9, -2, 3, 0, 0};
//        //快速排序
//        quickSort(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));

        int[] a = new int[8000000];
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

        //测试冒泡排序
        quickSort(a, 0, a.length - 1);

        //记录排序后的时间
        Date date2 = new Date();
        //创建格式化字符串
        String lastTime = simpleDateFormat.format(date2);
        System.out.println("排序前的时间为：" + lastTime);
    }

    //快速排序
    public static void quickSort (int[] arr, int left, int right) {
        int l = left;  //记录左下标
        int r = right;  //记录右下标
        int pivot = arr[(left + right) / 2];  //记录基准元素
        while (l < r) {
            //从基准元素左找到比基准元素大的元素
            while (pivot > arr[l]) {
                l++;
            }
            //从基准元素右找到比基准元素小的元素
            while (pivot < arr[r]) {
                r--;
            }
            //判断否越界
            if (l >= r) {
                break;
            }
            //交换元素值
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //若交换元素后判断交换位置俩个元素的大小与pivot
            if (arr[l] == pivot) {
                l++;
            }
            if (arr[r] == pivot) {
                r--;
            }
        }

        //如果r == l 必须l++ 和r--否则会出现栈溢出
        if (l == r) {
            l++;
            r--;
        }
        //向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        //向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }
    }
}
