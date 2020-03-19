package homework.java;

public class Test1 {
    public static void main (String args[]) {
        //输出第一个
        System.out.println("Kilogram       Pound");
        for (int i = 1; i <= 199; i = i + 2) {
            System.out.printf("%d            %.1f\n",i, i * 2.2);
        }
        //输出第二个
        float a = 9.09f;
        System.out.println("Kilogram       Pound");
        for (int j = 20; j <= 515; j = j + 5) {
            System.out.printf("%d            %.2f\n",j, a);
            a += 2.27;
        }
    }
}
