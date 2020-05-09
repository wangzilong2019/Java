package com.guigu.search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main (String args[]) {
        int[] arr = {0, 3, 5, 7, 8, 8};
//        int index = binarySearch(arr, 0, arr.length - 1, 10);
//        System.out.println("待查找元素索引为：" + index);

        //测试2
        List<Integer> resList = binarySearch2(arr, 0, arr.length - 1, 8);
        System.out.println("查找之后的索引为：" + resList);
    }

    public static int binarySearch(int[] arr, int left, int right, int value) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (value == arr[mid]) {
                return mid;
            } else if (value < arr[mid]) {
                return binarySearch(arr, left, mid - 1, value);
            } else {
                return binarySearch(arr, mid + 1, right, value);
            }
        }
        return -1;
    }


    /** 思路分析
     *   查找到value的索引值，不要立即返回
     *   向value左面扫描，直至索引小于0或不等于value，将索引加入集合中
     *   向value右面扫描，直至索引大于leng-1或不等于，将索引加入集合中
     *   返回集合
     *
     * */
    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int value) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (value == arr[mid]) {
                //创建一个集合用于存放索引
                ArrayList<Integer> indexList = new ArrayList<Integer>();
                int tempIndex = mid - 1;
                while (true) {
                    //退出循环条件
                    if (tempIndex < 0 || value != arr[tempIndex]) {
                        break;
                    }
                    //将索引加入集合中
                    indexList.add(tempIndex);
                    tempIndex -= 1;
                }
                indexList.add(mid);
                tempIndex = mid + 1;
                while (true) {
                    if (tempIndex > arr.length - 1 || value != arr[tempIndex]) {
                        break;
                    }
                    indexList.add(tempIndex);
                    tempIndex += 1;
                }
                return indexList;
            } else if (value < arr[mid]) {
                return binarySearch2(arr, left, mid - 1, value);
            } else {
                return binarySearch2(arr, mid + 1, right, value);
            }
        }
        //若没找到，返回一个空的ArrayList
        return new ArrayList<Integer>();
    }
}

