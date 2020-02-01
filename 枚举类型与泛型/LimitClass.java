package 泛型;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//限制泛型的类型
public class LimitClass<T extends List> {
    public static void main(String args[]) {
        //可以实例化已经实现List接口的类
        LimitClass<ArrayList> l1 = new LimitClass<ArrayList>();
        LimitClass<LinkedList> l2 = new LimitClass<LinkedList>();

    }
}

