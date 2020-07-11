package com.file.demo01file;

import java.io.File;

public class Demo03FilePath {
    public static void main(String[] args) {
        demo01();
        demo02();
        demo03();
        demo04();
    }

    /**
     *   无论传入参数时绝对路径还是相对路径，都返回绝对路径
     * */
    public static void demo01() {
        File file = new File("D:\\shiyan\\a.txt");
        String path = file.getAbsolutePath();
        System.out.println(path);

        File file1 = new File("a.txt");
        String path2 = file1.getAbsolutePath();
        System.out.println(path2);
    }

    /**
     *   此方法获取构造方法中传递的路径
     * */
    public static void demo02() {
        File file = new File("D:\\shiyan\\a.txt");
        String path = file.getPath();
        System.out.println(path);

        File file1 = new File("a.txt");
        String path2 = file1.getPath();
        System.out.println(path2);
    }

    /**
     *  获取构造方法传递路径的结尾部分（文件/文件夹）
     * */
    public static void demo03() {
        File file = new File("D:\\shiyan\\a.txt");
        String name = file.getName();
        System.out.println(name);

        File file1 = new File("D:\\shiyan");
        String name2 = file1.getAbsolutePath();
        System.out.println(name2);
    }

    /**
     *  获取构造方法所表示的文件大小（以字节为单位）
     *     注意：问价夹没有大小，不能获取
     *           若构造方法中给出的路径不存在，返回0
     * */
    public static void demo04() {
        File file = new File("D:\\shiyan\\a.txt");
        long l1 = file.length();
        System.out.println(l1);

        File file1 = new File("D:\\shiyan");
        long l2 = file1.length();
        System.out.println(l2);
    }
}
