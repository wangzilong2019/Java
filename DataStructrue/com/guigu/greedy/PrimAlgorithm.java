package com.guigu.greedy;

import com.guigu.graph.Graph;

import javax.naming.NamingEnumeration;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PrimAlgorithm {
    public static void main (String args[]) {

        Scanner input = new Scanner(System.in);
        int n, m;  //定义节点和边的个数
        System.out.println("请输入顶点个数n和边的个数m：");
        n = input.nextInt();
        m = input.nextInt();

        MGraph graph = new MGraph(n);
        //初始化
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                graph.weight[i][j] = MTree.INF;
            }
        }
        for (int i = 1; i <= n; i++) {
            graph.data[i] = (char)('A' + i - 1);
        }
        System.out.println("请输入俩个顶顶点u和v以及连接俩个顶点的边的权值w：");
        for (int i = 0; i < m; i++) {
            int u = input.nextInt();
            int v = input.nextInt();
            int w = input.nextInt();
            graph.weight[u][v] = w;
            graph.weight[v][u] = w;
        }

        MTree tree = new MTree();
        tree.Prim(graph, 1, n);

    }
}



//最小生成树
class MTree {
    static final int INF = 9999;


    /**
     *  graph代表图的邻接矩阵
     *  u0代表生成最小生成树的起始节点
     *  n代表图的节点总数
     * */
    public void Prim(MGraph graph,int u0, int n) {
        boolean[] flag = new boolean[n+1];  //创建标志数组标记加入集合u中的点
        int[] closeSet = new int[n+1];  //记录最短距离点i的前驱
        int[] lowCost = new int[n+1];  //记录到i点的最短距离的点

        //初始化矩阵
        for (int i = 1; i <= n; i++) {
            if (i != u0) {
                lowCost[i] = graph.weight[u0][i];
                closeSet[i] = u0;
                flag[i] = false;
            } else {
                lowCost[i] = 0;
            }
        }

        //将u0加入集合u中
        flag[u0] = true;
        //遍历u中每一个节点从v - u找到距离u中点最短距离的点
        for (int i = 1; i <= n; i++) {
            int temp = INF;
            int t = u0;
            //从v-u集合中找到距离u集合中最近的点
            for (int j = 1; j <= n; j++) {
                if (!flag[j] && lowCost[j] < temp) {
                    temp = lowCost[j];
                    t = j;
                }
            }

            //判断是否找到
            if (t == u0) {
                break;
            }
            //找打加入集合u中
            flag[t] = true;
            //更新集合
            for (int j = 1; j <= n; j++) {
                if (!flag[j] && graph.weight[t][j] < lowCost[j]) {
                    lowCost[j] = graph.weight[t][j];
                    closeSet[j] = t;
                }
            }
        }


        int sum = 0;
        for (int i = 1; i <= n; i++) {
            System.out.printf("%d ", lowCost[i]);
            sum += lowCost[i];
        }
        System.out.println();
        System.out.println("最小生成树的权值为：" + sum);
    }



}

//创建图
class MGraph {
    int verxs;  //记录图中顶点个数
    char[] data;  //记录每个顶点的信息
    int[][] weight;  //存储图的邻接矩阵

    //构造器
    public MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs+1];
        weight = new int[verxs+1][verxs+1];
    }
}