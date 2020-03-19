package homework.java;

public class Test2 {
    public static void main (String args[]) {
        //遍历100至1000数字
        for (int n = 100; n <= 1000; n++) {
            boolean a = n % 5 == 0;
            boolean b = n % 6 == 0;
            //判断是否只能被5或6一个整除
            if ((!a && b) || (a && !b)) {
                System.out.printf("%d ",n);
            }
        }
    }
}
