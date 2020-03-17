package com.guigu.queue;

import java.util.Scanner;

public class ArrayQueueDem {
    public static void main (String args[]) {
        //实例化类对象
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';
        //创建输入类对象
        Scanner input = new Scanner(System.in);
        boolean loop = true;
        //创建一个菜单栏
        while (loop) {
            System.out.println("输入a添加元素");
            System.out.println("输入g取出队头元素");
            System.out.println("输入s显示元素");
            System.out.println("输入h显示队头元素");
            System.out.println("输入e退出系统");
            System.out.printf("输入功能号：");
            key = input.next().charAt(0);  //获取一个字符
            switch (key) {
                case 'a' :
                    System.out.println("请输入要添加的元素：");
                    int value = input.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("对头元素为%d",res);
                    } catch (Exception e) {
                        System.out.printf(e.getMessage());
                    }
                    break;
                case 's' :
                    try {
                        System.out.printf("队列中的元素为：");
                        queue.showQueue();
                    } catch (Exception e) {
                        System.out.printf(e.getMessage());
                    }
                case 'h' :
                    try {
                        System.out.printf("队头元素为：");
                        int vlaue1 = queue.headQueue();
                    } catch (Exception e) {
                        System.out.printf(e.getMessage());
                    }
                    break;
                case 'e' :
                    //关闭输入流
                    input.close();
                    loop = false;
                    break;
            }
        }
        System.out.printf("退出系统");
    }
}
//创建ArrayQueue类
class ArrayQueue {
    //声明创建队列所需要的变量
    private int maxSize;  //声明队列长度
    private int front;  //列队头
    private int rear;  //列队尾
    private int [] arrayQueue;  //用于存放队列数组
    //创建队列构造器
    public ArrayQueue(int arrayMaxSize) {
        maxSize = arrayMaxSize;
        arrayQueue = new int [maxSize];  //创建队列数组
        front = -1;  //队列头，指向队头元素的前一个位置
        rear = -1;  //队列尾，指向队列的最后一个元素
    }
    //判断队列是否为满
    public boolean isFull() {
        return rear == maxSize - 1;
    }
    //判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }
    //元素入队
    public void addQueue(int n) {
        //判断是否为满
        if (isFull()) {
            System.out.println("队列已经满，不能入队");
            return;
        }
        rear++;
        arrayQueue[rear] = n;
    }
    //元素出队
    public int getQueue() {
        //判断是否为空
        if (isEmpty()) {
            //通过抛出异常
            throw new RuntimeException("队列为空，无法出队");
        }
        front++;
        return arrayQueue[front];
    }
    //输出队列元素
    public void showQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i < arrayQueue.length; i++) {
            System.out.printf("arrayQueue[%d] = %d", i, arrayQueue[i]);
        }
    }
    //显示队列头元素，而不是取出数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空无法取出");
        }
        return arrayQueue[rear+1];
    }
}
