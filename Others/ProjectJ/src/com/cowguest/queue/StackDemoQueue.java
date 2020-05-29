package com.cowguest.queue;

import java.util.ArrayList;
import java.util.Stack;

public class StackDemoQueue {
    public static void main (String args[]) {
        Solution solution = new Solution();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(i);
            solution.push(i);
            System.out.println(solution.pop());
        }


    }
}

class Solution {

    /**
     *   用俩个栈模拟一个队列
     *    1、添加元素时（入队）入stack1栈
     *    2、出栈时首先判断stack2是否为空，若不为空直接出栈栈顶元素，为空则将stack元素入栈，再从stack2元素出栈
     * */

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        //入栈stack1
        stack1.push(node);
    }

    public int pop() {
        //当stack2栈为空时
        if (stack2.size() <= 0) {
            //将stack1栈元素出栈入栈stack2
            while (stack1.size() != 0) {
                stack2.push(stack1.pop());
            }
        }
        //返回栈顶元素
        return stack2.pop();
    }
}