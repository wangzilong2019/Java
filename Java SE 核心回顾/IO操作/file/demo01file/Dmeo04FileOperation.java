package com.file.demo01file;

import com.map.hashmap.Demo04LinkedHashMap;

import java.io.File;

public class Dmeo04FileOperation {
    //判断File对象是否以文件或是文件夹结尾
    //判断File对象是否已文件夹结尾
    //public boolean isDirectory();
    //判断File对象是否以文件结尾
    //public boolean isFile();

    //创建一个新的文件
    //public boolean createNewFile();

    //删除改文件
    //public boolean delete();

    //判断文件是否存在
    //public boolean isExists();

    /**
     *   创建单级文件夹
     *      public boolean mkdir();
     *   既可以创建单级文件夹又可以创建多级文件夹
     *      public boolaen mkdirs()；
     *    注意：以上都是创建文件夹，返回值都是表示文件是否创建成功，不能创建问价
     * */
    public static void show() {
        File file = new File("D:\\aaa");
        boolean flag = file.mkdir();
        System.out.println(flag);

        File file1 = new File("D:\\ccc\\ddd");
        boolean flag1 = file1.mkdir();
        boolean flag2 = file1.mkdirs();
        System.out.println(flag1);
        System.out.println(flag2);


    }

    public static void main(String[] args) {
        show();
    }
}
