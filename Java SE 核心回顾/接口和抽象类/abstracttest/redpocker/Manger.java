package com.abstracttest.redpocker;

import java.util.ArrayList;

/**
 *   群主类
 *      特有方法发红包
 *
 * */
public class Manger extends User{

    public Manger() {
    }

    public Manger(String name, int money) {
        super(name, money);
    }


    /**
     *  发红包方法：
     *     totalMoney发红包总金额
     *     count 发红包总人数
     * */
    public ArrayList<Integer> send(int totalMoney, int count) {
        //创建一个集合用来存储发红包金额
        ArrayList<Integer> redList = new ArrayList<>();

        //首先判断余额是否够话红包
        int leftMoney = super.getMoney();
        if (totalMoney > leftMoney) {
            System.out.println("余额不足");
            return redList;
        }

        //扣钱，重新设置余额
        super.setMoney(leftMoney - totalMoney);

        //发红包平均拆成count份
        int avg = totalMoney / count;
        int mod = totalMoney % count;  //余数剩下的零钱

        //count-1份没人平均
        for (int i = 0; i < count - 1; i++) {
            redList.add(avg);
        }

        //最后一个人加余额
        int last = avg + mod;
        redList.add(last);

        //返回集合
        return redList;
    }
}
