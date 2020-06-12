package com.generic.demo.gather;

import java.util.ArrayList;
import java.util.Collection;

/**
 *  泛型的上限界定：? extends E  代表使用的泛型只能是E类型的子类/本身
 *  泛型的下限界定：? super E 代表使用的泛型只能是E类型的父类/本身
 * */
public class Demo6Generic {
    public static void main(String[] args) {
        Collection<Integer> col1 = new ArrayList<>();
        Collection<String> col2 = new ArrayList<>();
        Collection<Number> col3 = new ArrayList<>();
        Collection<Object> col4 = new ArrayList<>();

        getELement(col1);
        //getELement(col2);  //报错
        getELement(col3);
        //getELement(col4);   //报错

        //getELement2(col1);   //报错
        //getELement2(col2);   //报错
        getELement2(col3);
        getELement2(col4);
    }

    //泛型的上限，此时的泛型，必须为Number类型或是Number类型的子类
    public static void getELement(Collection<? extends Number> col){};
    //泛型的上下限，此时的泛型，必须为Number类型或是Number类型的子父类
    public static void getELement2(Collection<? super Number> col){};
}
