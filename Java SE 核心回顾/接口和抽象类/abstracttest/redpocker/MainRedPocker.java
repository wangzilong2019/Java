package com.abstracttest.redpocker;

import javax.swing.*;
import java.util.ArrayList;

/**
 *   发红包案例
 *      创建一个群主三个成员
 *
 * */
public class MainRedPocker {
    public static void main(String[] args) {
        //创建一个群主
        Manger manger = new Manger("群主", 100);

        //创建三个成员
        Member one = new Member("成员一", 0);
        Member two = new Member("成员二", 0);
        Member three = new Member("成员三", 0);

        //显示当前成员余额
        one.show();
        two.show();
        three.show();

        //群主发红包
        ArrayList<Integer> redList = manger.send(10, 3);

        //成员抢红包
        one.receive(redList);
        two.receive(redList);
        three.receive(redList);

        //显示余额
        one.show();
        two.show();
        three.show();
    }
}
