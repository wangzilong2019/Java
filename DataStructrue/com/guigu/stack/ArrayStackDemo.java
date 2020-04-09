package com.guigu.stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main (String args[]) {
        //创建一个栈对象
        ArrayStack stack = new ArrayStack(4);
        //从键盘输入的操作
        String key = "";
        Scanner input = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("show：表示显示栈中的元素");
            System.out.println("exit：表示退出程序");
            System.out.println("push：表示向栈中添加元素（入栈）");
            System.out.println("pop：表示从栈中取出元素（出栈）");
            System.out.println("请输入所要执行的操作：");
            key = input.next();
            switch (key) {
                case "show":
                    System.out.println("遍历栈中的元素为：");
                    stack.list();
                    break;
                case "exit":
                    //要关闭输入流，避免资源泄露
                    input.close();
                    loop = false;
                    break;
                case "push":
                    System.out.println("请输入要入栈的元素");
                    int data = input.nextInt();
                    //执行入栈操作
                    stack.push(data);
                    break;
                case "pop":
                    //异常处理
                    try {
                        int res = stack.pop();
                        System.out.println("要出栈的数组元素是：" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
    }
}

//定义类表示栈的结构
class ArrayStack{
    private int maxSize;//表示栈的大小
    private int[] stack;//数组来存放栈
    private int top = -1;//栈顶指针

    //栈的构造方法
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //判断栈是否为空
    public boolean isEmpty() {
        return top == -1;
    }

    //判断栈是否为满
    public boolean isFull() {
        return top == maxSize-1;
    }

    //入栈操作
    public void push (int value) {
        //判断栈是否为满
        if (isFull()) {
            System.out.printf("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈操作
    public int pop () {
        //判断栈是否为空
        if (isEmpty()) {
            throw new RuntimeException("栈空，无法出栈");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈（从栈顶元素开始）
    public void list() {
        //判断栈是否为空
        if (isEmpty()) {
            System.out.printf("栈为空，无法遍历");
            return;
        }
        //需要从栈顶开始显示数据
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }
    }
}
