package com.guigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSort {
    public static void main (String args[]) {
        //冒泡排序算法
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
        bubbleSort(a);

        //记录排序后的时间
        Date date2 = new Date();
        //创建格式化字符串
        String lastTime = simpleDateFormat.format(date2);
        System.out.println("排序前的时间为：" + lastTime);



    }
    public static void bubbleSort (int[] a) {
        //外层循环排序趟数
        boolean flag = false;
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length-i; j++) {
                //比较相邻俩个元素大小
                if (a[j] > a[j+1]) {
                    flag = true;
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
            //System.out.println("第" + i + "排序后的结果为：" + Arrays.toString(a));
            //判断是否要继续排列
            if ( !flag ) {  //一次记录都没有交换过
                break;
            } else {
                flag = false;
            }
        }
    }
}
