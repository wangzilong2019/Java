package com.guigu.greedy;

import com.guigu.graph.Graph;

import java.util.Arrays;

public class PrimAlgorithm {
    public static void main (String args[]) {
        //存放图的顶点信息
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E'};
        //节点个数
        int verxs = data.length;
        //创建图的邻接矩阵
        int[][] weight = new int[][] {

        }

        //创建MGraph对象
        MGraph mGraph = new MGraph(verxs);
        //创建MTree对象
        MTree mTree = new MTree();
        mTree.createGraph(mGraph, verxs, data, weight);
    }
}

//最小生成树
class MTree {

    public void createGraph(MGraph graph, int verxs, char[] data, int[][] weight) {
        for (int i = 0; i < verxs; i++) {
            graph.data[i] = data[i];
            for (int j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }

        //显示图的邻接矩阵
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
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
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}