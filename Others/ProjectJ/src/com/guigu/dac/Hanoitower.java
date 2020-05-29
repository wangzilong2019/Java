package com.guigu.dac;

public class Hanoitower {
    public static void main (String args[]) {
        hanoiTower(5, 'A', 'B', 'C');

    }

    /**  分治算法求解汉诺塔问题
     *     1、若只有一个盘子A->C
     *     2、若盘子个数 >= 2 ，可以看作俩个盘子：1、上面的盘子2、下面的盘子
     *        1、A->B
     *        2、A->C
     *        1、A->C
     * */
    public static void hanoiTower(int num, char a, char b, char c) {
        //当只有一个盘子时A->C
        if (num == 1) {
            System.out.println("第1个盘子从" + a + " -> " + c);
        } else {
            //当盘子个数大于2个时，先将num-1个盘子从A借助C移动到B
            hanoiTower(num - 1, a, c, b);
            //将第最下面的盘子从A->C
            System.out.println("第" + num + "个盘子从" + a + " -> " + c);
            //再将num - 1个盘子从借助A移动到C
            hanoiTower(num - 1, b, a, c);
        }
    }
}
