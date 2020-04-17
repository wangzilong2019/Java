package com.guigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {
    public static void main (String args[]) {
        //待排序元素的初始序列
        //int[] arr = {9, -1, 3, 6, 2};

        //测试案例
        int[] arr = new int[80000];
        for (int i = 0; i <arr.length; i++) {
            arr[i] = (int) (Math.random()*80000);
        }

        //排序前记录时间
        Date date1 = new Date();
        //对时间进行格式化
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateCur = simpleDateFormat.format(date1);
        System.out.println("排序前时间：" + dateCur);
        insertSort(arr);

        //排序后的时间
        Date date2 = new Date();
        String dateLast = simpleDateFormat.format(date2);
        System.out.println("排序后时间：" + dateLast);

    }

    //插入排序
    public static void insertSort (int[] arr) {
        //进行数组长度-1趟查找
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];  //记录待插入元素
            int insertIndex = i-1; //记录待插入元素的前一个坐标

            //循环查找待插入的位置
            /**1、insertIndex >= 0保证待找到待插入的位置时不越界
             * 2、insertValue < arr[insertIndex] 表示没有找到待插入的位置
             * 3、若没找到需要将元素后移
             * */
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }

            //插入元素，判断是否需要移动元素
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertValue;
            }
            //System.out.println("第" + i + "趟排序后的元素为：" + Arrays.toString(arr));
        }
    }
}
