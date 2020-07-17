package com.InnerClass.demoinnerclass.demo04;

import java.util.ArrayList;
import java.util.List;

public class DemoInterfaceArgs {
    public static void main(String[] args) {
        //多态创建集合
        List<String> list = new ArrayList<>();

        List<String> list1 = addNames(list);

        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }
    }

    //接口作为方法参数和返回值
    public static List<String> addNames(List<String> list) {
        list.add("往");
        list.add("事");
        return list;
    }
}
