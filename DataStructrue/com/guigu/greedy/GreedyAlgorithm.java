package com.guigu.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 贪心算法求最小点的个数覆盖全部集合
 *   1、遍历每一个顶点找到未覆盖的城市的数量的最大的顶点的
 *   2、将这些顶点从全集中删除
 *   3、重复1、2直至全集中城市为空
 *
 * */




public class GreedyAlgorithm {
    public static void main (String args[]) {
        //创建HashMap将电台集合加入K中
        HashMap<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();
        //将电台加入集合中

        HashSet<String> hashSet1 = new HashSet<String>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<String>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<String>();
        hashSet4.add("天津");
        hashSet4.add("上海");

        HashSet<String> hashSet5 = new HashSet<String>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        //将电台集合加入Map
        map.put("K1", hashSet1);
        map.put("K2", hashSet2);
        map.put("K3", hashSet3);
        map.put("K4", hashSet4);
        map.put("K5", hashSet5);

        //此集合存放所有地区
        HashSet<String> allArea = new HashSet<String>();
        allArea.add("北京");
        allArea.add("上海");
        allArea.add("天津");
        allArea.add("杭州");
        allArea.add("大连");
        allArea.add("广州");
        allArea.add("深圳");
        allArea.add("成都");

        //创建一个集合用来存放选择的地点
        ArrayList<String> select = new ArrayList<String>();

        //创建一个临时集合来存放每一个电台的城市
        HashSet<String> temp = new HashSet<String>();

        //创建一个指针用来指向最大的电台
        String maxKey = null;
        while (allArea.size() != 0) {  //如果此集合中还有元素，说明还没有覆盖到所有城市
            //清空maxKey
            maxKey = null;

            //遍历map每次找到最大的未覆盖城市的集合
            for (String key : map.keySet()) {
                //将临时集合清空
                temp.clear();
                //存放每一次集合中的城市
                HashSet<String> areas = map.get(key);
                //将此集合中的元素放入临时集合中
                temp.addAll(areas);
                //求出临时集合和全集的叫交集
                temp.retainAll(allArea);
                if (temp.size() > 0 && (maxKey == null || temp.size() > map.get(maxKey).size())) {
                    maxKey = key;
                }
            }

            if (maxKey != null) {
                select.add(maxKey);
                allArea.removeAll(map.get(maxKey));
            }
        }
        System.out.println("最终选择得到的结果是：" + select);

    }
}
