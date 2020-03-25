package com.guigu.linkedlist;

import java.util.Stack;

public class TestStack {
    public static void main (String args[]) {
        //创建一个栈对象
        Stack<String> stack = new Stack<>();
        //入栈操作
        stack.add("TOM");
        stack.add("LILY");
        stack.add("BOBO");
        //出栈操作
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }
}
