package com.guigu.recursion;

public class MiGong {

    static int count = 0;//此变量用来统计步数
    static int bestc = 8888;
    static int[][] bestp = new int[8][7];
    public static void main (String args[]) {
        //创建一个二维数组来表示路径
        int[][] map = new int[8][7];
        //对原始矩阵初始化map的值为1时表示为墙
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        for (int j = 0; j < 7; j++) {
            map[0][j] = 1;
            map[7][j] = 1;
        }
        //初始化俩个点
        map[3][1] = 1;
        map[3][2] = 1;
        System.out.println("输入原来的地图情况：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.printf("%d ", map[i][j]);
            }
            System.out.println();
        }

        //将小球回溯找路径
        setWay(map, 1, 1);
        System.out.println("输入更新之后的地图：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.printf("%d ", bestp[i][j]);
            }
            System.out.println();
        }
    }

    //此函数用来统计步数
    public static int countf(int[][] map) {
        int count = 0;
        int i = 0;
        for (int[] x: map) {
            i++;
            int j = 0;
            for (int e : x) {
                j++;
                //统计步数
                if (e == 2) {
                    count++;
                }
            }
        }
        //返回步数
        return count;
    }

    //走迷宫看开始
    public static boolean setWay (int[][] map, int i, int j) {
        //判断是否走到终点
        if (map[6][5] == 2) {
            //记录最优解
            count = countf(map);
            //找到最优解记录
            if (count < bestc) {
                bestc = count;
                for (int a = 0; a < 8; a++) {
                    for (int b = 0; b < 7; b++) {
                        bestp[a][b] = map[a][b];
                    }
                }
            }
            return true;
        } else {
            //若为0表明时路可以走
            if (map[i][j] == 0) {
                //走完之后置为2 假设表示可以走通标号为2，不可以走通编号为3
                map[i][j] = 2;
                //判断下、右、上、左。四个方向是否可以走通
                if (setWay(map, i+1, j)) {  //向下走
                    return true;
                } else if (setWay(map, i, j+1)) {  //向右走
                    return true;
                } else if (setWay(map, i-1, j)) {  //向上走
                    return true;
                } else if (setWay(map, i, j-1)) {  //向左走
                    return true;
                } else {
                    //四个方向都走不通则陷入死胡同
                    map[i][j] = 3;
                    return false;
                }
            } else {
                //若此路径不为0，则为1，2，3则不能走
                return false;
            }
        }
    }
}
