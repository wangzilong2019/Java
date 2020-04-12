package com.guigu.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String args[]) {
//        //定义一个逆波兰表达式
//        String suffixExpression = "3 4 + 5 * 6 -";
//
//        List<String> rpnList = getListString(suffixExpression);
//        System.out.println("rpnList = " + rpnList);
//        int res = calculate(rpnList);
//        System.out.println("计算的结果是："+ res);

        //定义中缀表达式为
        String str = "1+((2+3)*4)-5";
        //将中缀表达式抓换成对应的list
        List<String> list = toInfixExpressionString(str);
        System.out.println("转化前的中缀表达式序列list = " + list);
        List<String> suffixList = parseSuffixList(list);
        System.out.println("转化后的逆波兰序列为list = " + suffixList);
        //运算结果
        System.out.println("expression = " + calculate(suffixList));

    }

    //将中缀表达式list转成后缀表达式list
    public static List<String> parseSuffixList(List<String> list) {
        //首先创建俩个栈，一个存放符号，另一个存放数据
        Stack<String> s1 = new Stack<String>();
        //这里因为第二个栈不进行出栈操作，所以可用list替代
        List<String> s2 = new ArrayList<String>();

        //进行表达式转换
        for (String item : list) {
            //判断此字符串是数字串还是符号串，若为数字串
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {  //若为左括号则直接入栈s1
                s1.push(item);
            } else if (item.equals(")")) {
                //若为右括号）则一次弹出s1栈顶的运算符，并加入s2中，直至遇到右括号为止，此时将一对括号丢弃
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                //将"("弹出，消除小括号
                s1.pop();
            } else {
                //当item的优先级小于s1栈顶的优先级，依次弹出s1栈顶的运算符到s2中
                while (s1.size()!=0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                //还需要将item压入栈中
                s1.push(item);
            }
        }
        //将s1中剩余的元素加入到s2中
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2; //因为是存放到list中，依次正常的输出就是对应的逆波兰序列
    }

    //将一个逆波兰表达式，将数字和字符分别放入list中
    public static List<String> getListString(String suffixExpression) {
        //将逆波兰表达式分割成字符串
        String[] split = suffixExpression.split(" ");
        //创建List数组
        List<String> list = new ArrayList<String>();
        for (String e:split) {
            list.add(e);
        }
        return list;
    }

    //将中缀表达式转换成对应的list
    public static List<String> toInfixExpressionString(String s) {
        int i = 0;//遍历字符串
        char c;//记录当前字符
        String str = "";//用来做字符串拼接
        List<String> list = new ArrayList<String>();
        do {
            //判断索引位置字符是否数字或是符号
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                list.add(""+c);
                i++;
            } else {
                str = "";
                //若是一个数，要考虑多为数字
                while (i < s.length() && (c=s.charAt(i)) >= 48 && (c=s.charAt(i)) <= 57) {
                    str += c;
                    i++;
                }
                list.add(str);
            }
        }while (i < s.length());
        return list;
    }

    //计算逆波兰表达式
    public static int calculate (List<String> ls) {
        //创建一个栈
        Stack<String> stack = new Stack<String>();
        //遍历字符串数组
        for (String item : ls) {
            //使用正则表达式判断当前字符串若是数字串则入栈
            if (item.matches("\\d+")) {
                stack.push(item);
            }
            //若是符号则进行运算
            else {
                //先出栈俩个数，转换成数字
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1+num2;
                } else if (item.equals("-")) {
                    res = num1-num2;
                } else if (item.equals("*")) {
                    res = num1*num2;
                } else if (item.equals("/")) {
                    res = num1/num2;
                } else {
                    throw new RuntimeException("符号错误");
                }
                //将结果入栈
                stack.push(""+res);
            }
        }
        //返回最后在栈中的数据
        return Integer.parseInt(stack.pop());

    }
}

//编写一个Operation类来比较运算符的优先级
class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //编写函数返回运算符的优先级
    public static int getValue (String key) {
        int res = 0;
        switch (key) {
            case "+":
                res = ADD;
                break;
            case "-":
                res = SUB;
                break;
            case "*":
                res = MUL;
                break;
            case "/":
                res = DIV;
                break;
            default:
                System.out.println("该运算符不存在");
                break;
        }
        return res;
    }
}
