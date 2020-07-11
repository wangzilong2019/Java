package com.file.demo01file.buffered;

import java.io.*;
import java.util.HashMap;

/**
 *    练习：
 *       对文本内容进行排序
 *       按照1，2，3进行排序
 *    分析
 *       创建一个HashMap集合，将key存放每行的序号1，2，3，value存放文本内容
 */
public class Demo05Text {
    public static void main(String[] args) throws IOException {
        //创建HashMap集合存放键值对
        HashMap<String, String> map = new HashMap<>();
        BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"));
        //1、创建FileReader对象
        FileReader fr = new FileReader("in.txt");
        //2、创建BufferedReader对象
        BufferedReader br = new BufferedReader(fr);
        //3、以每行读取文本内容
        String line = null;
        while ((line = br.readLine()) != null) {
            //3、以.作为分隔符分割
            String[] arr = line.split("\\.");
            //将内容写入map集合中(key序号是有序的，会自动排序)
            map.put(arr[0], arr[1]);
        }
        //4、遍历集合将内容写入文本中
        for (String key : map.keySet()) {
            String value = map.get(key);
            line = key + "." + value;
            bw.write(line);
            bw.newLine();
        }
        //释放资源
        bw.close();
        br.close();
    }
}
