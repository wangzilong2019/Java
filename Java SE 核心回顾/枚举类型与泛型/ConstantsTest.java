package 枚举类型与泛型;

interface Constants {
    //将常量放在接口中
    public static final int Constants_A = 1;
    public static final int Constants_B = 12;
}
public class ConstantsTest {
    //将常量放在枚举类型中
    enum Constants2 {
        Constants_A,
        Constants_B;
    }
    //定义一个方法，参数为int型
    public static void doit1(int c) {
        switch (c) {
            case Constants.Constants_A :
                System.out.println("doit() Constants_A");
                break;
            case Constants.Constants_B :
                System.out.println("doit1()Constants_B");
                break;
        }
    }
    //定义一个方法，参数对象为枚举类型
    public static void doit2(Constants2 c) {
        switch (c) {
            case Constants_A:
                System.out.println("doit2()Constants_A");
                break;
            case Constants_B:
                System.out.println("doit2()Constants_B");
                break;
        }
    }
    public static void main(String args[]) {
        //使用接口中定义的常量
        ConstantsTest.doit1(Constants.Constants_A);
        //使用枚举体中定义的常量
        ConstantsTest.doit2(Constants2.Constants_A);
        ConstantsTest.doit2(Constants2.Constants_B);
    }
}