package com.guigu.stack;

import java.util.Scanner;

public class calculator {
    public static void main (String args[]) {
        String operation = " ";
        Scanner input = new Scanner(System.in);
        //从键盘输入一个字符串
        operation = input.next();
        //首先创建俩个栈
        ArrayStack2 operStack = new ArrayStack2(10);
        ArrayStack2 numStack = new ArrayStack2(10);
        //定义变量
        int res = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = ' ';
        int index = 0;
        String keepNum = "";
        while (true) {
            //当遍历完成字符串之后退出循环
            if (index >= operation.length()) {
                break;
            }
            //截取字符
            char ch = operation.substring(index, index+1).charAt(0);
            //若此字符为操作符
            if (operStack.isOper(ch)) {
                //判断操作符栈是否为空，当不为空时
                if (!operStack.isEmpty()) {
                    //判断字符优先级，若此字符的优先级小于等于操作符栈顶的优先级
                    if (operStack.priority(ch) <= operStack.peek()) {
                        //从数据栈pop俩个数据，再从符号栈pop一个符号，计算
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.calculate(num1, num2, oper);
                        //将计算结果和符号入栈
                        numStack.push(res);
                        operStack.push(ch);
                    }
                    //当此字符的优先级大于操作符栈顶优先级时
                    else {
                        operStack.push(ch);
                    }
                }
                //到操作符栈为空时
                else {
                    operStack.push(ch);
                }
            }
            //若此字符为数字
            else {
                //当为单位数字时执行该操作
                //numStack.push(ch-48);
                //处理多位数字
                keepNum += ch;
                //如果ch为所计算的字符串的最后一位则入栈
                if (index == operation.length()-1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    //判断下一个运算符是否是数字，若是数字则继续扫描，运算符则入栈
                    if (operStack.isOper(operation.substring(index+1, index+2).charAt(0))) {
                        //如果最后一个时运算符，则入栈
                        numStack.push(Integer.parseInt(keepNum));
                        //重要的是keepNum清空
                        keepNum = "";
                    }
                }

            }
            //指针后移
            index++;
        }

        //当表达式扫描完毕，就从数据栈和符号栈pop计算
        while (true) {
            //当字符栈为空时则计算完毕
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.calculate(num1, num2, oper);
            numStack.push(res);
        }
        System.out.println("表达式" + operation + "=" + numStack.pop());
    }
}

//定义类表示栈的结构
class ArrayStack2{
    private int maxSize;//表示栈的大小
    private int[] stack;//数组来存放栈
    private int top = -1;//栈顶指针

    //栈的构造方法
    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //读取栈顶元素
    public int peek () {
        return stack[top];
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

    //判断操作符的优先级,优先级越高，返回的数字越大
    public int priority(int oper) {
        if (oper=='*' || oper=='/') {
            return 1;
        } else if (oper=='-' || oper=='+') {
            return 0;
        } else {
            return -1;
        }
    }

    //判断是不是一个操作符
    public boolean isOper(char oper) {
        return oper=='+' || oper=='-' || oper=='*' || oper=='/';
    }

    //计算
    public int calculate(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1+num2;
                break;
            case '-':
                res  = num2-num1;
                break;
            case '*':
                res = num1*num2;
                break;
            case '/':
                res = num2/num1;
                break;
            default:
                break;
        }
        return res;
    }
}

