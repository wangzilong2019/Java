package com.file.demo01file;

import java.io.File;

public class Dmeo05FileTravesal {

    /**
     *   文件遍历
     *     list方法和listFiles方法遍历的是构造方法中给出的目录
     *     构造方法中给出的目录不存在或不是目录则抛出空指针异常
     * */

    /**
     *   public String[] list();  返回一个字符串数组，表示File目录中所有的子文件或目录
     *     也可以获取隐藏文件，返回每个文件或问价夹名称
     * */
    public static void show() {
        File file = new File("D:\\tools");
        String[] arr = file.list();
        for (String e : arr) {
            System.out.println(e);
        }
    }

    /**
     *   public File[] listFiles();  返回一个File数组，表示File目录中所有的子文件或目录
     *      返回数组中每个元素的绝对路径
     */
    public static void showe() {
        File file = new File("D:\\tools");
        File[] arr = file.listFiles();
        for (File f : arr) {
            System.out.println(f);
        }
    }


    /**
     *    递归遍历一个文件夹中所有的文件以及文件夹
     */
    public static void getDirectoy(File dir) {
        //打印被遍历的目录名称
        System.out.println(dir);
        //获取当前文件夹下的问价以及文件夹
        File[] files = dir.listFiles();
        //遍历File数组
        for (File f : files) {
            //判断是文件还是文件夹
            if (f.isDirectory()) {
                getDirectoy(f);
            } else {
                System.out.println(f);
            }
        }
    }

    /**
     *   遍历问价夹下的所有文件及问价夹，获取特定类型文件
     * */
    public static void getDirectoy2(File dir) {
        //打印被遍历的目录名称
        System.out.println(dir);
        //获取当前文件夹下的问价以及文件夹
        File[] files = dir.listFiles();
        //遍历File数组
        for (File f : files) {
            //判断是文件还是文件夹
            if (f.isDirectory()) {
                getDirectoy(f);
            } else {
                /**
                 * String name = f.getName();
                 * String path = f.getPath();
                 */
                String s = f.toString();
                boolean flag = s.endsWith(".java");
                if (flag) {
                    System.out.println(f);
                }
            }
        }
    }

    public static void main(String[] args) {
        show();
        showe();
        File file = new File("D:\\tools");
        getDirectoy(file);
        getDirectoy2(file);
    }
}
