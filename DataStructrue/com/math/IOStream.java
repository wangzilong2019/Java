package com.math;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class IOStream {
    public static void main (String args[]) {
        //创建文件对象
        File file = new File("word.txt");
        try {
            //创建FileReader对象
            FileReader fr = new FileReader(file);
            //创建BufferedReader对象
            BufferedReader bufr = new BufferedReader(fr);
            //创建字符串变量对象
            String str = null;
            //当文本行数不为null时，则继续循环
            while ((str = bufr.readLine()) != null) {
                //分割字符串
                String[] strSplit = str.split("\t");
                for (int i = 0; i < strSplit.length; i++) {
                    if (i != 1) {
                        System.out.println(Integer.parseInt(strSplit[i]));
                    }
                }
                //System.out.println();
            }
            //关闭流
            bufr.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
