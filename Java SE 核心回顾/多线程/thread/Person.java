package com.thread;

public class Person {
    private String name;

    public void run() {
        //定义循环执行20次
        for (int i = 0; i < 20; i++) {
            System.out.println(name + " --> " + i);
        }
    }

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
