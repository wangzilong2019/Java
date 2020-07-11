package com.file.demo01file;

import java.io.File;

public class Demo02File {
    /**
     *  创建File类对象时：
     *     文件路径可以不存在
     *     可以以文件夹或文件结尾
     *
     * */
    public static void demo01() {
        File file = new File("D:\\d\\a.txt");
        System.out.println(file);
    }

    public static void demo02(String parent, String child) {
        File file = new File(parent, child);
        System.out.println(file);
    }

    public static void demo03() {
        File parent = new File("D:\\");
        File file = new File(parent, "a.txt");
        System.out.println(file);
    }

    public static void main(String[] args) {
        demo01();
        demo02("C:\\", "c.txt");
        demo03();
    }
}
