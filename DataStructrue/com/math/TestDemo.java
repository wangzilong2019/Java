package com.math;

import javax.imageio.stream.FileImageOutputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TestDemo{
    public static void main (String args[]) {
        new Problem();
        DrawTest.createMain();
    }
}

//生成最小生成树
class Problem {
    final static int N = 8888;
    final static int INF = 8888;
    static double[] lowCost = new double[N];  //代表u0到i点的最短权值
    static int[] closeSet = new int[N];  //代表与顶点i相连接点最短权值的前驱()
    static boolean[] flag = new boolean[N];
    static double[][] map = new double[N][N];
    Node[] nodes = new Node[182];
    //用于存放临时的俩个点
    int tempa;
    int tempb;
    public Problem() {

        DrawTest drawTest = new DrawTest();
        int n = 181;  //节点总数

        //加载点
        //创建文件对象
        File file = new File("word.txt");
        try {
            //创建FileReader对象
            FileReader fr = new FileReader(file);
            //创建BufferedReader对象
            BufferedReader bufr = new BufferedReader(fr);
            //创建字符串变量对象
            String str = null;
            //创建对象数组

            int i = 1;  //记录行数
            //当文本行数不为null时，则继续循环
            while ((str = bufr.readLine()) != null) {
                //分割字符串
                String[] strSplit = str.split("\t");
                //记录该节点编号
                int num = Integer.parseInt(strSplit[0]);
                //记录该节点坐标
                int x = Integer.parseInt(strSplit[strSplit.length - 2]);
                int y = Integer.parseInt(strSplit[strSplit.length - 1]);

                //创建节点
                nodes[i] = new Node();
                nodes[i].setNum(num);
                nodes[i].setX(x);
                nodes[i].setY(y);

                i++;
            }
            //关闭流
            bufr.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //初始化带权图的邻接矩阵
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                //Node引用数组下标从1开始的
                int x1 = nodes[i].getX();
                int y1 = nodes[i].getY();
                int x2 = nodes[j].getX();
                int y2 = nodes[j].getY();

                map[i][j] = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
            }
        }
        //计算最小费用之和
        Prim(n, 1, map);

        //连线


        System.out.println("数组lowCost内容为：");
        for (int i = 1; i <= n; i++) {
            System.out.println(lowCost[i]);
        }
        //double sumCost = 0;
        double sumCostI = 0;
        double sumCostII = 0;
        //计算最小花费之和
        for (int i = 1; i <= n; i++) {
            //sumCost += lowCost[i];
            //当为一级管道时
            if (i <= 13 && closeSet[i] <= 13) {
                sumCostI += lowCost[i];
            } else {
                sumCostII += lowCost[i];
            }
        }
        System.out.println("一级管道sumCostI花费为：" + sumCostI);
        System.out.println("二极管道sumCostII花费为：" + sumCostII);


        //问题2
        double minCostII = INF;
        double minCostI = INF;
        for (int a = 14; a <= n; a++) {
            for (int b = a + 1; b <= n; b++) {

                sumCostI = 0;
                sumCostII = 0;
                //计算最小花费之和
                for (int i = 1; i <= n; i++) {
                    //sumCost += lowCost[i];

                    //将改为的一级管道和原有的一级管道相加
                    if ((i == a && closeSet[i] <= 13) || (i == b && closeSet[i] <= 13) || (i <= 13 && closeSet[i] <= 13)) {
                        sumCostI += lowCost[i];
                    } else {
                        sumCostII += lowCost[i];
                    }
                }

                //每次更新之后记录最优解
                if (minCostII > sumCostII) {
                    minCostII = sumCostII;
                    minCostI = sumCostI;
                    tempa = a;
                    tempb = b;
                }
            }
        }
        System.out.println("改装后的一级管道sumCostI花费为：" + minCostI);
        System.out.println("改装后的二级管道sumCostII花费为：" + minCostII);


    }

    //浦路斯卡尔算法求最小生成树
    /**
     *  思路：
     *    1、首先创建俩个俩个集合U和V，任意选择一个点放入U中，作为源点，剩下的节点V-U
     *    2、每次从V中选取可以与U联通的最短的权值的一个节点，将此节点加入U
     *    3、直到所有节点都加入其中
     * */

    /**
     *  @n 代表顶点个数（供水点总数）
     *  @u0  代表起始点编号
     *  @map  代表带权的邻接矩阵
     *
     * */

    public static void Prim(int n, int u0, double[][] map) {

        //初始时，U集合中只有一个元素即为u0
        flag[u0] = true;
        //初始化
        for (int i = 1; i <= n; i++) {
            if (i != u0) {  //除了u0之外的其它顶点
                lowCost[i] = map[u0][i];  //u0到其它顶点边的权值
                closeSet[i] = u0;  //最临界点初始化位u0
                flag[i] = false;  //初始化u0顶点不属于u的集合
            } else {
                lowCost[i] = 0;
            }
        }

        //在V-U中寻找距离集合U最近的顶点t
        for (int i = 1; i <= n; i++) {
            double temp = INF;
            int t = u0;
            //在集合V-U中找到记录集合U最近的顶点t
            for (int j = 1; j <= n; j++) {
                if ( (!flag[j]) && (lowCost[j] < temp)) {
                    t = j;
                    temp = lowCost[j];
                }
            }
            //若没找到则退出
            if (t == u0) {
                break;
            }
            //否则加入集合flag;
            flag[t] = true;
            //更新lowCost和closeSet
            for (int j = 1; j <= n; j++) {
                if ( (!flag[j]) && (map[t][j] < lowCost[j])) {
                    lowCost[j] = map[t][j];
                    closeSet[j] = t;
                }
            }
        }
    }

}



//创建一个窗口且加载点
class DrawTest extends JFrame{
    //Node[] nodes = new Node[182];
    public DrawTest() {
        //调用父类构造方法
        super();
        //调用初始化方法
        initialize();
    }

    //初始化方法
    public void initialize() {
        this.setSize(1000, 700);  //设置窗体大小
        this.setTitle("绘制几何图形"); //设置标题
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //设置关闭方法
        MyCanvas myCanvas = new MyCanvas();
        add(myCanvas);
    }

    public static void createMain () {
        new com.math.DrawTest().setVisible(true);
    }

    //创建一个画布
    private class MyCanvas extends Canvas{
        //方法覆盖
        public void paint(Graphics g) {
            //super.paint(g);
            Graphics2D g2 = (Graphics2D) g;

            //加载点
            //创建文件对象
            File file = new File("word.txt");
            try {
                //创建FileReader对象
                FileReader fr = new FileReader(file);
                //创建BufferedReader对象
                BufferedReader bufr = new BufferedReader(fr);
                //创建字符串变量对象
                String str = null;
                //创建对象数组

                int i = 1;  //记录行数
                //当文本行数不为null时，则继续循环
                while ((str = bufr.readLine()) != null) {
                    //分割字符串
                    String[] strSplit = str.split("\t");
                    //记录该节点编号
                    int num = Integer.parseInt(strSplit[0]);
                    //记录该节点坐标
                    int x = 11 * Integer.parseInt(strSplit[2]);
                    int y = 11 * Integer.parseInt(strSplit[3]);


                    //通过i的大小来判断管道级别
                    if (i == 1) {
                        //供水点画图
                        g2.drawOval(x, y, 5, 5);
                        //System.out.println(" x:" + x/11 + " y:" + y/11);

                    } else if (i <= 13 || i == new Problem().tempa || i == new Problem().tempb) {
                        //设置一级供水点图标
                        g2.setColor(Color.ORANGE);
                        //设置填充图形
                        g2.fillRect(x, y, 5, 5);
                        //System.out.println(" x:" + x/11 + " y:" + y/11);
                    } else {
                        //设置二级供水点颜色
                        g2.setColor(Color.BLUE);
                        //设置填充矩形
                        g2.fillRect(x, y, 5, 5);
                    }
                    i++;
                }
                Problem problem = new Problem();
                //通过每个最优解记录的前驱连线
                for (int p = 2; p <= 181; p++) {
                    g2.drawLine(11 * problem.nodes[p].getX(), 11 * problem.nodes[p].getY(), 11 * problem.nodes[Problem.closeSet[p]].getX(), 11 * problem.nodes[Problem.closeSet[p]].getY());
                }

                //关闭流
                bufr.close();
                fr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}


//创建节点
class Node{
    private int x, y;  //每个点的坐标
    private int num;  //节点编号

    //节点构造器
    public Node() {
    }

    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
}
