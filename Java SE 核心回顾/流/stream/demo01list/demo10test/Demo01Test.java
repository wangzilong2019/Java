package com.stream.demo01list.demo10test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 *
 */
public class Demo01Test {
    public static void main(String[] args) {
        List<String> one = new ArrayList<>();

        List<String> one1 = new ArrayList<>();
        //第一个队伍只要长度为2的名字
        for (String name : one) {
            if (name.length() == 3) {
                one1.add(name);
            }
        }

        Stream<String> stream = one.stream().filter(name->name.length() == 2);

        //第一支退伍筛选之后需要前3个人
        List<String> one2 = new ArrayList<>();
        for (int i = 0; i < one1.size(); i++) {
            if (i < 3) {
                one2.add(one1.get(i));
            }
        }

        Stream<String> stream1 = stream.limit(3);



    }
}
