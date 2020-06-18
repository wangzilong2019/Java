package com.abstracttest.redpocker;

/**
 *  用户类：
 *     姓名
 *     余额
 * */
public class User {
    private String name;
    private int money;

    //显示用户余额
    public void show() {
        System.out.println("姓名：" + name + "余额：" + money);
    }

    public User() {
    }

    public User(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
