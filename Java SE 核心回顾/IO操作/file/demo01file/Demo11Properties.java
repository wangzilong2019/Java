package com.file.demo01file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * Properties 类
 *        extends Hashtable<Object,Object>Properties 类表示了一个持久的属性集，
 *        Properties 可保存在流中或从流中加载
 *        Properties集合是唯一一个与IO流相结合的集合
 *          可用Properties集合中的store方法，将集合中的临时数据，持久写入到磁盘中存储
 *          可用Properties集合中的load方法，把硬盘中的文件（键值对），读入到集合中
 *      属性列表中每个键和值对应的都是一个字符串
 *         Properties集合是一个双列集合，默认key和value都是字符串
 */
public class Demo11Properties {
    public static void main(String[] args) throws IOException{
        show01();
        show02();
        show03();
    }

    /***
     *    使用Properties集合中的load方法，把硬盘中保存的文件（键值对），读取到集合中
     *         void load(Reader reader)
     *           按简单的面向行的格式从输入字符流中读取属性列表（键和元素对）
     *         void load(InputStream inStream)
     *           从输入流中读取属性列表（键和元素对）。
     *    参数：
     *       OutputStream out  字节输入流，不能写中文
     *       Writer writer  字符输入流，可以写中文
     *     使用步骤：
     *        创建Properties集合对象
     *        调用load方法读取保存键值对的文件数据到集合中
     *        遍历集合
     *     注意：
     *        存储键值对的文件中，键与值默认的连接符号可以使用
     *        存储键值对的文件中，可以使用#作为注释，被注释的键值对不再被读取
     *        存储键值对的文件中，键与值默认都是字符串，不用再加引号
     */
    private static void show03() throws IOException {
        //创建集合对象
        Properties prop = new Properties();
        //将文件中数据读取到集合中保存
        prop.load(new FileReader("a.txt"));
        //遍历集合
        Set<String> set = prop.stringPropertyNames();
        for (String key : set) {
            String value = prop.getProperty(key);
            System.out.println(key + "=" + value);
        }
    }

    /**
     *    Properties集合操作字符串的一些方法
     *    Object setProperty(String key, String value)
     *           调用 Hashtable 的方法 put。
     *     String getProperty(String key)
     *           用指定的键在此属性列表中搜索属性，相当于map中的get(key)
     *    Set<String> stringPropertyNames()
     *           返回此属性列表中的键集，其中该键及其对应值是字符串，如果在主属性列表中未找到同名的键，则还包括默认属性列表中不同的键。
     */
    private static void show01() {
        //创建集合对象
        Properties prop = new Properties();
        //向集合中添加数据
        prop.setProperty("马龙", "175");
        prop.setProperty("张继科", "180");
        prop.setProperty("樊振东", "170");

        //获取key集合
        Set<String> set = prop.stringPropertyNames();

        //遍历集合
        for (String key : set) {
            String value = prop.getProperty(key);
            System.out.println(key + "=" + value);
        }
    }

    /**
     *    使用Properties集合中的store方法，可将集合中的临时数据，持续化写入到磁盘中存储
     *        void store(OutputStream out, String comments);
     *        void store(Writer writer, String comments);
     *     参数：
     *        OutputStream out  字节输入流，不能写中文
     *        Writer writer  字符输入流，可以写中文
     *        String comments   注释，用来解释说明保存的文件是做什么用的
     *                           不能使用中文，会产生乱码，一般默认是UNICODE编码
     *                           一般不使用空字符串
     *      使用步骤：
     *          创建Properties集合对象，添加数据
     *          创建字节输出流/字符输出流对象，构造方法中要绑定的输出的目的地
     *          使用Properties集合中的store方法，把集合中的临时数据，持久化存储到磁盘中
     *          释放资源
     */
    private static void show02() {
        //1、创建集合对象
        Properties prop = new Properties();
        //向集合中添加数据
        prop.setProperty("马龙", "175");
        prop.setProperty("张继科", "180");
        prop.setProperty("樊振东", "170");

        //2、创建字符输入流对象
        FileWriter fr = null;
        try {
            fr = new FileWriter("a.txt");

            //3、将数据存储到文件中
            prop.store(fr, "save data");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //4、释放资源
        prop.clone();
    }
}
