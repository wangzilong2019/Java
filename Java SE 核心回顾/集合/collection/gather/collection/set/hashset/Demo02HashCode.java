package com.gather.collection.set.hashset;

/**
 *    哈希值：是一个十进制的整数，由系统随机给出，是一个对象的逻辑地址，不是实际的物理地址
 *        在Object类中有一个方法可以获取哈希值
 *          public native int hashCode()
 *             native代表是本地方法
 * */
public class Demo02HashCode {
    public static void main(String[] args) {
        //Person继承了Object类，所以可以使用hashCode()方法
        Person p1 = new Person();
        int h1 = p1.hashCode();
        System.out.println(h1);

        Person p2 = new Person();
        int h2 = p2.hashCode();
        System.out.println(h2);

        /**
         *   toString() 方法源码
         *     return getClass().getName + "@" + Integer.toHexString(hashCode());
         *
         * */
        System.out.println(p1);
        System.out.println(p2);

        /**
         *   重写String类中的hashCode()方法
         *
         * */
        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println("重地" + s1.hashCode());
        System.out.println("通话" + s2.hashCode());
    }
}
