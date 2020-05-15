package com.guigu.greedy;

import com.guigu.graph.Graph;

import java.util.Arrays;
import java.util.Comparator;

public class KruskalAgorithm {
    public static void main (String args[]) {

    }
}

//最小生成树
class Tree{
    int[] nodest;  //存放集合号

    //对边的权值进行排序
//    public void sortEdge(Edge edge) {
//        for (int i = 1; i < edge.verxs; i++) {
//            for (int j = 1; j < edge.verxs - i; j++) {
//                if (edge.edge[j] > edge.edge[j+1]) {
//                    int temp = edge.edge[j];
//                    edge.edge[j] = edge.edge[j+1];
//                    edge.edge[j+1] = temp;
//                }
//            }
//        }
//    }

    //初始化各边的集合号
    public void init(Edge edge) {
        nodest = new int[edge.verxs + 1];
        for (int i = 1; i <= edge.verxs; i++) {
            nodest[i] = i;
        }
    }

    //将边合并进入集合
    public boolean merge(int a, int b, Edge edge) {
        //计算俩个集合号
        int p = nodest[a];
        int q = nodest[b];
        //判断是否可以合并
        if (p == q) {
            return false;
        }

        //遍历每一个集合号，将p改为q
        for (int i = 1; i <= edge.verxs; i++) {
            if (nodest[i] == p) {
                nodest[i] = q;
            }
        }
        return true;
    }

    //kruskal算法
    public void kruskal(Edge edge) {
        //遍历每一条边找到权值最小的
        for (int i = 1; i <= edge.verxs; i++) {
            //判断此条边是否可以合并
            if (merge(edge.edge[i].))
        }
    }


}

//创建存储图的边
class Edge  {
    int u, v;  //存储俩个点
    int[] edge;
    int verxs;

    //构造器
    public Edge(int verxs) {
        edge = new int[verxs + 1];
        this.verxs = verxs;
    }
}
