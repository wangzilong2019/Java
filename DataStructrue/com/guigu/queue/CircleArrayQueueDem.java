package com.guigu.queue;

import java.util.Scanner;

public class CircleArrayQueueDem {
    public static void main (String args[]) {
        //实例化类对象
        CircleArrayQueue queue = new CircleArrayQueue(3);
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
//创建CircleArrayQueue类
class CircleArrayQueue {
    private int front;  //指向环形队列的首元素
    private int rear;  // 指向环形队列尾元素的下一个位置
    private int maxSize;  //定义环形队列容量
    private int [] arr;  //数组存放环形队列
    //环形队列构造器
    public CircleArrayQueue (int max) {
        maxSize = max;
        arr = new int[maxSize];
        //这里因为默认rear和front值为0所以可以不用赋值
    }
    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }
    //判断队列是否为满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }
    //向队列中添加元素
    public void addQueue(int n) {
        //判断是否为满
        if (isFull()) {
            System.out.println("队列已经满，不能入队");
            return;
        }
        arr[rear] = n;
        //尾指针后移
        rear = (rear + 1) % maxSize;
    }
    //元素出队
    public int getQueue() {
        //判断是否为空
        if (isEmpty()) {
            //通过抛出异常
            throw new RuntimeException("队列为空，无法出队");
        }
        int vlaue;
        vlaue = arr[front];
        //头指针后移一位
        front = (front + 1) % maxSize;
        return vlaue;
    }
    //显示队列头元素，而不是取出数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空无法取出");
        }
        return arr[front];
    }
    //输出队列元素
    public void showQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arrayQueue[%d] = %d", i % maxSize, arr[i % maxSize]);
        }
    }
    //计算队列有效数据个数
    public int size() {
        return (rear + maxSize -front) % maxSize;
    }

}
