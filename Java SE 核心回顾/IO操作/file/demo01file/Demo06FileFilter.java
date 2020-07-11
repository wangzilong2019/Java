package com.file.demo01file;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class Demo06FileFilter {
    /**
     *  文件过滤器
     *     File类中有俩个重载lisTfiles的方法，方法的参数传递的就是过滤器
     *     File[] listFies(FileFilter fileFilter);   用来过滤文件File对象
     *     File[] listFile(FileNameFilter fileNameFilter);   用来过滤文件名称
     *
     *   注意：俩个过滤器方法没有实现类，使用时需要重写实现类
     */

    /**
     *   使用过滤器过滤.java结尾的文件
     * */
    public static void getDirectoy2(File dir) {
        //打印被遍历的目录名称
        //使用匿名内部类创建
//        File[] files = dir.listFiles(new FileFilter() {
//            @Override
//            public boolean accept(File file) {
//                //当为文件夹时或是.java文件返回true
//                return file.isDirectory() || file.toString().toLowerCase().endsWith(".java");
//            }
//        });

        //最简化lamda表达式
//        File[] files = dir.listFiles(file -> file.isDirectory() || file.toString().toLowerCase().endsWith(".java"));

        //使用FileNameFilter过滤器
//        File[] files = dir.listFiles(new FilenameFilter() {
//            @Override
//            public boolean accept(File file, String s) {
//                return new File(file, s).isDirectory() || s.toLowerCase().endsWith(".java");
//            }
//        });

        //使用lamda表达式，条件：接口中只有一个抽象方法
//        File[] files = dir.listFiles((file, s) -> {
//                return new File(file, s).isDirectory() || s.toLowerCase().endsWith(".java");
//            }
//        );

        //方法中只有一行代码，可以这样简化
        File[] files = dir.listFiles((file, s) -> new File(file, s).isDirectory() || s.toLowerCase().endsWith(".java"));

        //遍历File数组
        for (File f : files) {
            //判断是文件还是文件夹
            if (f.isDirectory()) {
                getDirectoy2(f);
            } else {
                System.out.println(f);
            }
        }
    }

    public static void main(String[] args) {
        File file = new File("D:\\tools");
        getDirectoy2(file);
    }
}
