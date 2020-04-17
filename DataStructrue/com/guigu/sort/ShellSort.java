package com.guigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {
    public static void main (String args[]) {
        int[] arr = {9, 21, -2, 4, 3, 89};
        //shellSort(arr);

        //测试案例
        //向数组中添加元素
        int[] a = new int[80000];
        for (int i = 0; i < 80000; i++) {
            a[i] = (int) (Math.random()*80000);
        }

        //记录排序前的时间
        Date date1 = new Date();
        //创建格式化字符串
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String curTime = simpleDateFormat.format(date1);
        System.out.println("排序前的时间为：" + curTime);

        //测试希尔排序
        //shellSort(a);
        shellSort2(a);

        //记录排序后的时间
        Date date2 = new Date();
        //创建格式化字符串
        String lastTime = simpleDateFormat.format(date2);
        System.out.println("排序前的时间为：" + lastTime);


        //shellSort2(arr);
        //System.out.println(Arrays.toString(arr));
    }

    //西尔排序交换法
    public static void shellSort (int[] arr) {
        int count = 0;
        //外层循环来定义增量
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            //此层循环来记录待交换元素的后一个元素的位置
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j = j - gap) {
                    //比较元素大小
                    if (arr[j] > arr[j+gap]) {
                        int temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }
            //System.out.println("第" + ++count + "趟" + "排序结果为：" + Arrays.toString(arr));
        }
    }

    //移位法
    public static void shellSort2 (int[] arr) {
        int count = 0;
        for (int gap = arr.length; gap > 0; gap = gap / 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                //判断前一个元素是否大于后一个
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动位置
                        arr[j] = arr[j - gap];
                        j = j - gap;
                    }
                    //当退出while循环时，temp插入此时的位置
                    arr[j] = temp;
                }
            }
        }
    }
}
