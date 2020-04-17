package com.guigu.sort;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {
    public static void main (String args[]) {
        //int[] arr = {19, 2, -3, 8, 10};
        //System.out.println("排序前的数组元素为：" + Arrays.toString(arr));
        //selectSort(arr);
        //System.out.println("排序后的数组元素为：" + Arrays.toString(arr));

        //创建存放80000个随机数的数组
        int[] a = new int[80000];
        //向数组中添加元素
        for (int i = 0; i < 80000; i++) {
            a[i] = (int) (Math.random()*80000);
        }

        //记录排序前的时间
        Date date1 = new Date();
        //创建格式化字符串
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String curTime = simpleDateFormat.format(date1);
        System.out.println("排序前的时间为：" + curTime);

        //测试冒泡排序
        selectSort(a);

        //记录排序后的时间
        Date date2 = new Date();
        //创建格式化字符串
        String lastTime = simpleDateFormat.format(date2);
        System.out.println("排序前的时间为：" + lastTime);
    }

    //直接选择排序算法
    public static void selectSort (int[] arr) {
        //先假设一段数组中起始元素为最小值，从后面依次找到最小值
        //进行数组长度-1趟
        for (int i = 0; i < arr.length-1; i++) {
            //假设当前第一个元素为最小值
            int minValue = arr[i];
            int minIndex = i;
            //从后序元素中找到最小值
            for (int j = i+1; j < arr.length; j++) {
                if (minValue > arr[j]) {
                    minValue = arr[j];
                    minIndex = j;
                }
            }
            //若当前元素为最小值不用交换，否则交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = minValue;
            }
        }
    }
}
