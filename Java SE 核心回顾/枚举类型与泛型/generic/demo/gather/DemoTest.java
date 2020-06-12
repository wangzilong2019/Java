package com.generic.demo.gather;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

/**
 *   斗地主案例
 *      1、准备牌
 *      2、洗牌
 *      3、发牌
 *      4、看牌
 *
 * */
public class DemoTest {
    public static void main(String[] args) {
        /**
         *   准备牌
         *      创建一个集合存储每张牌
         * */
        ArrayList<String> pocks = new ArrayList<>();
        //定义牌花色
        String[] colors = {"♥", "♠", "♣", "♦"};
        //定义牌的序号
        String[] numbers = {"2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3"};
        pocks.add("大王");
        pocks.add("小王");
        for (String color : colors) {
            for (String number : numbers) {
                pocks.add(color + number);
            }
        }

        /**
         *   洗牌
         *     调用静态方法
         * */
        Collections.shuffle(pocks);

        /**
         *  发牌
         *     创建四个集合，三个集合分别存放三个人的牌，一个集合存放底牌
         *     注意：每个人17张牌，剩余3张底牌,当i >= 51时留底牌
         * */
        ArrayList<String> play1 = new ArrayList<>();
        ArrayList<String> play2 = new ArrayList<>();
        ArrayList<String> play3 = new ArrayList<>();
        ArrayList<String> dipai = new ArrayList<>();

        for (int i = 0; i < pocks.size(); i++) {
            //当i >= 51 时留作底牌
            if (i >= 51) {
                dipai.add(pocks.get(i));
            } else if (i % 3 == 0) {
                play1.add(pocks.get(i));
            } else if (i % 3 == 1) {
                play2.add(pocks.get(i));
            } else if (i % 3 == 2) {
                play3.add(pocks.get(i));
            }
        }

        /**
         * 看牌
         * */
        System.out.println(play1);
        System.out.println(play2);
        System.out.println(play3);
        System.out.println(dipai);

    }
}
