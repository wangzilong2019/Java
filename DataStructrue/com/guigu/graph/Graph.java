package com.guigu.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    private ArrayList<String> vertexList;  //存放图的顶点
    private int[][] edges;  //存放图的边
    private int numOfEdges;  //存放边总数
    private boolean[] isVis;  //表示节点是否被访问过

    public static void main (String args[]) {
        //测试案例
        String[] vertexs = {"A", "B", "C", "D", "E"};
        int n = 5;  //节点个数
        //创建图
        Graph graph = new Graph(n);
        //像图中添加节点
        for (String vertex : vertexs) {
            graph.insertVertex(vertex);
        }
        //添加边A-C A-B B-C B-D B-E
        graph.insertEdges(0, 1, 1);
        graph.insertEdges(0, 2, 1);
        graph.insertEdges(1, 2, 1);
        graph.insertEdges(1, 3, 1);
        graph.insertEdges(1, 4, 1);

        graph.showGraph();

//        System.out.println("深度优先遍历");
//        graph.dfs();
        System.out.println("广度优先搜索");
        graph.bfs();
    }

    // 图的构造器
    public Graph(int n) {
        //初始化
        vertexList = new ArrayList<String>(n);
        edges = new int[n][n];
        numOfEdges = 0;
        isVis = new boolean[n];
    }

    //查找到返回i的第一个临界点的下标，否则返回-1
    public int getFirstNeighbor(int i) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[i][j] > 0) {
                return j;
            }
        }
        //否则返回-1
        return -1;
    }

    //根据前一个邻接点的坐标获取下一个邻接点
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //深度优先遍历算法
    public void dfs(boolean[] isVis, int i) {
        //输出第一个节点
        System.out.println(getValueByIndex(i) + " -> ");
        //并设置为已访问
        isVis[i] = true;
        //求出当前节点第一个邻接点
        int w = getFirstNeighbor(i);
        //若存在
        while (w != -1) {
            //当未被访问过时
            if ( !isVis[w] ) {
                //把w作为v
                dfs(isVis, w);
            }
            //如果节点已经被访问过
            w = getNextNeighbor(i, w);
        }
    }

    //进行函数重载
    public void dfs() {
        for (int i = 0; i < numOfVertex(); i++) {
            //若未被访问过
            if (!isVis[i]) {
                dfs(isVis, i);
            }
        }
    }

    //广度优先遍历
    public void bfs(boolean[] isVis, int i) {
        int u;  //表示队列的头节点对应的下标
        int w;  //表示u的邻接点
        //创建一个链表模拟队列
        LinkedList queue = new LinkedList();
        //访问节点输出信息
        System.out.println(getValueByIndex(i) + " -> ");
        //标志为已访问
        isVis[i] = true;
        //将节点i入队
        queue.addLast(i);
        //当队列非空时
        while (!queue.isEmpty()) {
            //取出队头元素下标
            u = (Integer) queue.removeFirst();
            //查找u的邻接点w
            w = getFirstNeighbor(u);
            //若找到邻接点
            while (w != -1) {
                //若未被访问过
                if (!isVis[w]) {
                    System.out.println(getValueByIndex(w) + "->");
                    //标志已访问
                    isVis[w] = true;
                    //将 元素入队
                    queue.addLast(w);
                }
                //找到以u位前驱w为邻接点的下一个邻接点
                w = getNextNeighbor(u, w);
            }
        }

    }

    //方法重载
    public void bfs() {
        for (int i = 0; i < numOfVertex(); i++) {
            if (!isVis[i]) {
                bfs(isVis, i);
            }
        }
    }

    //插入节点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    //添加边
    public void insertEdges(int u, int v, int weight) {
        edges[u][v] = weight;
        edges[v][u] = weight;
        numOfEdges++;
    }

    //返回图中的节点数
    public int numOfVertex() {
        return vertexList.size();
    }

    //饭hi图中的边数
    public int numOfEdge() {
        return numOfEdges;
    }

    //返回节点i对应的数据
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //返回u和v节点对应的权值
    public int getWeightByIndex(int u, int v) {
        return edges[u][v];
    }

    //显示对应的矩阵
    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }
}
