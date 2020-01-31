package 枚举类型与泛型;

public class EnumIndexTest_01 {
    enum Constants2 {
        //定义有参数的枚举类型成员
        Constants_A("我是枚举成员A"),
        Constants_B("我是枚举成员B"),
        Constants_C("我是枚举成员C"),
        Constants_D(3);
        private String description;
        private int i = 4;
        private Constants2() {

        }
        //定义参数为description的构造方法
        private Constants2(String description) {
            this.description = description;
        }
        //定义参数为i的构造方法
        private Constants2(int i) {
            this.i = this.i + i;
        }
        //获取i的值
        public int getI() {
            return i;
        }
        //获取description的值
        public String getDescription() {
            return description;
        }
    }
    public static void main(String args[]) {
        for (int i = 0 ; i < Constants2.values().length; i++) {
            System.out.println(Constants2.values()[i] + "调用getDescription()方法为：" + Constants2.values()[i].getDescription());
        }
        System.out.println("Constants_D调用getI()方法为：" + Constants2.valueOf("Constants_D").getI() );
    }
}
