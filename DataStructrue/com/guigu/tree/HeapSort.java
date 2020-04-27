package com.guigu.tree;

import java.util.Arrays;

public class HeapSort {
    public static void main (String args[]) {
        int[] arr = {4, 6, 8, 5, 9, 0, 900};
        heapSort(arr);
    }

    public static void heapSort(int[] arr) {
        //首先将一个待排序列调成大根堆
        //构建大根堆从下至上、从左至右
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
  //      adjustHeap(arr, 0, arr.length);

        //调整堆结构+交换堆顶元素与堆尾元素
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, i);
        }
        System.out.println("堆排序结果：" + Arrays.toString(arr));
    }


    //调整为一颗大根堆
    /**
     *  arr为待调整数组（二叉树）
     *  i 为非叶子节点
     *  length为待调整数组长度，length逐渐减小
     */

    public static void adjustHeap(int[] arr, int i, int lengtht) {
        //记录当前堆顶 元素
        int temp = arr[i];
        for (int k = 2*i+1; k < lengtht; k = k*2+1) {
            //找到当前节点的俩个叶子节点的最大值
            if (k+1 < lengtht && arr[k] < arr[k+1]) {
                k++;
            }
            //将最大叶子节点与当前节点比较
            if (temp < arr[k]) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        //for循环结束后，以i为根节点的树的最大值，放到了树的顶部
        arr[i] = temp;
    }
}
