package 枚举类型与泛型;

public class EnumMethodTest {
    enum Constants2 {
        //将常量放置在枚举类型中
        Constants_A,
        Constants_B
    }
    //定义比较枚举类型的方法，参数为枚举类型
    public static void compare (Constants2 c) {
        //根据values()方法返回数组做循环操作
        for (int i = 0 ; i < Constants2.values().length; i++) {
            System.out.println(c + "与" + Constants2.values()[i] + "比较结果是" + c.compareTo(Constants2.values()[i]));
        }
    }
    //在主方法中调用比较方法
    public static void main(String args[]) {
        EnumMethodTest.compare(Constants2.Constants_A);
        EnumMethodTest.compare(Constants2.valueOf("Constants_B"));
        //比较结果，正值代表方法中参数在调用该方法的枚举对象之前
    }
}
