package com.map.hashmap.demotest;

import java.lang.reflect.Array;
import java.util.*;

/**
 *   斗地主案例二
 *       增添新功能。使得每个人手中牌有序
 *
 * */
public class DemoTest {
    public static void main(String[] args) {
        //创建一个集合存放拍的颜色
        List<String> colors = List.of("♥", "♠", "♣", "♦");
        //创建一个集合存放牌
        List<String> nums = List.of("2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");
        //创建一个集合存放索引
        ArrayList<Integer> pockerIndex = new ArrayList<>();
        //创建一个hashMap存放牌（目的通过索引排序）
        HashMap<Integer, String> pockers = new HashMap<>();

        int index = 0;
        pockers.put(index, "大王");
        pockerIndex.add(index++);
        pockers.put(index, "小王");
        pockerIndex.add(index++);

        for (String num : nums) {
            for (String color : colors) {
                pockers.put(index, color + num);
                pockerIndex.add(index++);
            }
        }

        //洗牌
        Collections.shuffle(pockerIndex);

        //创建三个玩家集合，一个底牌集合
        ArrayList<Integer> play1 = new ArrayList<>();
        ArrayList<Integer> play2 = new ArrayList<>();
        ArrayList<Integer> play3 = new ArrayList<>();
        ArrayList<Integer> dipai = new ArrayList<>();

        for (int i = 0; i < pockerIndex.size(); i++) {
            int indexPccker = pockerIndex.get(i);
            if (i >= 51) {
                dipai.add(indexPccker);
            } else if (i % 3 == 0) {
                play1.add(indexPccker);
            } else if (i % 3 == 1) {
                play2.add(indexPccker);
            } else if (i % 3 == 2) {
                play3.add(indexPccker);
            }
        }

        //对拍排序
        Collections.sort(play1);
        Collections.sort(play2);
        Collections.sort(play3);
        Collections.sort(dipai);

        /**
         *   看牌
         * */
        show("樊振东",pockers, play1);
        show("马龙", pockers, play2);
        show("张继科", pockers, play3);
        show("底牌", pockers, dipai);

    }

    public static void show(String name, HashMap<Integer, String> map, ArrayList<Integer> list) {
        System.out.println("输出玩家的名字：" + name);
        for (Integer key : list) {
            String value = map.get(key);
            System.out.printf(value + " ");
        }
        System.out.println("--------------------------");
    }
}
