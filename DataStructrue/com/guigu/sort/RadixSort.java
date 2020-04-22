package com.guigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RadixSort {
    public static void main (String args[]) {
//        int[] arr = new  int[]{19, 34, 10, 8, 7};
//        radixSort(arr);
//        System.out.println("排序后元素：" + Arrays.toString(arr));

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
        radixSort(arr);

        //排序后的时间
        Date date2 = new Date();
        String dateLast = simpleDateFormat.format(date2);
        System.out.println("排序后时间：" + dateLast);
    }

    //基数排序算法
    public static void radixSort (int[] arr) {

        /**1、定义一个二维数组，表示10个桶，每个桶表示1个一维数组
         * 说明：1、二维数组包含10个一维数组
         *       2、防止溢出，每个一维数组的大小为arr.length
     *
         * */
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中数据的个数
        int[] bucketElementCounts = new int[10];
        //首先找到数组中元素的最大值，依次来确定最长位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        //求最大元素的位数
        int len = (max + "").length();
        //对每个元素的每位进行基数排序，从个位开始
        for (int i = 0, n = 1; i < len; i++, n = n*10) {
            //将每一个元素的相同位数分解，然后记录在数组中
            for (int j = 0; j <arr.length; j++) {
                //计算出倒数第i+1位
                int digitOfElement = arr[j] / n % 10;
                //将已计算数字存入桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                //计数器加1
                bucketElementCounts[digitOfElement]++;

            }

            //遍历原数据，将桶中数据放入原数组
            int index = 0;
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //当桶中有元素不为空时
                if (bucketElementCounts[k] != 0) {
                    //循环数组将第i个桶放入
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放入到arr中
                        arr[index++] = bucket[k][l];
                    }
                }
                //第i+1轮循环后，需要将第i个桶的计数器清零
                bucketElementCounts[k] = 0;
            }
        }



    }
}
