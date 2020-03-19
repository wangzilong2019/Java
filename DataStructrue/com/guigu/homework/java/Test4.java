package homework.java;

public class Test4 {
    public static void main (String args[]) {
        //创建Test4类对象
        Test4 test4 = new Test4();
        System.out.println(test4.method(12,25.7));
    }
    //找到比i小的数值
    public static double method (double i, double j) {
        //若i > j 直接返回j
        //否则j做自减运算，直到第一次找到比i小的值
        while (i < j) {
            j--;
        }
        return j ;
    }
}
