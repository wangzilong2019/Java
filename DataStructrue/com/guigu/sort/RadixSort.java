package com.guigu.sort;

import java.util.Arrays;

public class RadixSort {
    public static void main (String args[]) {
        int[] arr = new  int[]{9, 4, -2, 8, 7};
        radixSort(arr);
        System.out.println("排序后元素：" + Arrays.toString(arr));
    }

    //基数排序算法
    public static void radixSort (int[] arr) {

        int[][] bucket = new int[10][arr.length];
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
                if (bucketElementCounts[i] != 0) {
                    //循环数组将第i个桶放入
                    for (int l = 0; l < bucketElementCounts.length; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                //第i+1轮循环后，需要将第i个桶的计数器清零
                bucketElementCounts[k] = 0;
            }
        }



    }
}
