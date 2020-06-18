package com.abstracttest.redpocker;

import java.util.ArrayList;
import java.util.Random;

/**
 *  成员类
 *
 * */
public class Member extends User{
    public Member() {
    }

    public Member(String name, int money) {
        super(name, money);
    }

    /**
     *   成员抢红包
     *
     * */
    public void receive (ArrayList<Integer> redList) {
        //从红包中随机抽一个红包
        int index = new Random().nextInt(redList.size());
        //获取红包大小并删除该红包
        int delta = redList.remove(index);
        //获取当前余额
        int money = super.getMoney();
        //将抢到的红包放入自身钱
        super.setMoney(money + delta);
    }
}
