package com.collections.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *    使用Collections接口中的方法对集合进行排序
 *        注意：被排序的元素必须实现Comparable接口，重写compareTo方法
 *    规定
 *       自己-参数  ：升序
 *       否则降序
 * */
public class Demo01Sort {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(6);
        System.out.println(list);

        //使用sort方法排序，默认升序
        Collections.sort(list);
        System.out.println(list);

        //（方法一）重写compareTo()方法降序排列
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return t1 - integer;
            }
        });
        //（方法二）使用lambda表达式
        Collections.sort(list, (Integer t1, Integer t2)->t1-t2);
        System.out.println(list);
    }
}
