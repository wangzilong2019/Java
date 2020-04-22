package com.guigu.hashtab;

import java.util.Scanner;

public class HashTabDemo {
    public static void main (String args[]) {
        //创建一个hash表
        HashTab hashTab = new HashTab(7);
        //写一个简单的菜单
        String key = "";
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("add：添加雇员");
            System.out.println("list：显示雇员");
            System.out.println("find：查找雇员");
            System.out.println("delete：删除雇员");
            System.out.println("exit：退出系统");
            key = input.next();  //输入菜单指令
            switch (key) {
                case "add" :
                    System.out.println("请输入要添加的id和name：");
                    int id;
                    String name = "";
                    id = input.nextInt();
                    name = input.next();
                    //创建一个节点
                    Emp emp = new Emp(id, name);
                    //将节点添加到hash中
                    hashTab.add(emp);
                    break;
                case "list" :
                    hashTab.list();
                    break;
                case "find" :
                    System.out.println("请输如要查找的id：");
                    id = input.nextInt();
                    hashTab.findById(id);
                    break;
                case "delete" :
                    System.out.println("请输入要删除雇员的id：");
                    id = input.nextInt();
                    hashTab.deleteById(id);
                    break;
                case "exit" :
                    input.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}

//创建雇员节点信息
class Emp{
    public int id; //雇员id
    public String name; //雇员名字
    Emp next;  //指向下一个节点指针
    //节点构造器
    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}

//创建链表
class EmpLinkedList{
    private Emp head;  //创建头指针

    //添加节点
    //说明：加入链表节点id为自增的，则直接采用尾插法即可
    public void add(Emp emp) {
        //当前链表为空时，直接插入即可
        if (head == null) {
            head = emp;
            return;
        }
        //首先定义一个指针直线第一个节点
        Emp temp = head;
        //当前链表节点不为空时，找到链表最后一个节点插入
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = emp;
    }

    //根据id查找雇员
    public Emp findEmpById (int id) {
        //当前链为空，返回空
        if (head == null) {
            System.out.print("链表为空");
            return null;
        }
        Emp temp = head;  //定义一个指针表里链表
        while (true) {
            //当遍历到尾时还没找到，退出循环
            if (temp == null) {
                break;
            }
            if (temp.id == id) {
                return temp;
            }
            temp = temp.next;
        }
        return temp;
    }

    //删除指定id的雇员信息
    public void deleteById(int id) {
        //当前链表为空直接返回
        if (head == null) {
            System.out.println("查无此雇员");
            return;
        }
        //若第一节点即为要删除的节点
        if (head.id == id) {
            head = head.next;
            System.out.println("雇员删除成功");
            return;
        }
        //定义一个指针遍历链表
        Emp temp = head;
        while (true) {
            //当遍历至表尾未找到直接返回
            if (temp == null) {
                System.out.println("查无此雇员");
                break;
            }
            if (id == temp.next.id) { //找到
                Emp emp1 = temp.next;
                temp = emp1.next;
                System.out.println("雇员删除成功");
                break;
            }
        }
    }

    //遍历链表
    public void list(int no) {
        //当前链表为空直接返回
        if (head == null) {
            System.out.println("第" + no +"条链表为空");
            return;
        }
        System.out.println("第" + no +"条链表中雇员的信息：");
        Emp temp = head;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.printf(" => id = %d name = %s\t", temp.id, temp.name);
            temp = temp.next;
        }
    }
}

//创建HashTab
class HashTab{
    private EmpLinkedList[] empLinkedList;  //创建数组元素为链表
    private int size;  //数组大小

    //构造器构造哈希表
    public HashTab(int size) {
        this.size = size;
        empLinkedList = new EmpLinkedList[size];
        //这里有一个埪，注意要同时初始化每一个链表
        for (int i = 0; i <size; i++) {
            empLinkedList[i] = new EmpLinkedList();
        }
    }

    //添加雇员
    public void add(Emp emp) {
        int empLinkedListNo = hashFun(emp.id);  //确定添加位置
        empLinkedList[empLinkedListNo].add(emp);
    }

    //根据输入id查找
    public void findById(int id) {
        //适用散列表确定查找哪条链表
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedList[empLinkedListNo].findEmpById(id);
        if (emp != null) {  //找到
            System.out.printf("在第%d条链表中找到雇员id = %d\n", empLinkedListNo+1, id);
        } else {
            System.out.println("在哈希表中没有找到该雇员");
        }
    }

    //删除雇员
    public void deleteById(int id) {
        //找到该id所归属的链表
        int empLinkedListNo = hashFun(id);
        empLinkedList[empLinkedListNo].deleteById(id);
    }

    //遍历所有的链表
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedList[i].list(i + 1);
        }
    }

    //构造散列表
    public int hashFun(int id) {
        return id % size;
    }
}
