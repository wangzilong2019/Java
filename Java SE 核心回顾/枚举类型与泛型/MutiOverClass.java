package 泛型;

import java.util.HashMap;
import java.util.Map;

public class MutiOverClass<K,V> {
    //定义一个HashMap集合
    public Map<K,V> m = new HashMap<K,V>();
    //设置put()方法，将对应的键值对存入相应的集合
    public void put(K k, V v) {
        m.put(k,v);
    }
    //根据键名获取键值
    public V get(K k) {
        return m.get(k);
    }
    public static void main(String args[]) {
        //实例化泛型类对象
        MutiOverClass<Integer,String> mu = new MutiOverClass<Integer, String>();
        //根据集合长度循环将键名加入集合
        for (int i = 0; i < 5; i++) {
            mu.put(i,"我是成员变量");
        }
        for (int i = 0; i < mu.m.size(); i++) {
            System.out.println(mu.get(i)+i);
        }
    }
}
