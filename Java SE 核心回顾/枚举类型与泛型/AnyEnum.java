package 枚举类型与泛型;

interface d {
    public String getDescription();
    public int getI();
}
public enum  AnyEnum implements d {
    //在枚举类型内部设置构造方法
    Constants_A{
        public String getDescription() {
            return ("我是枚举类型A");
        }
        public int getI() {
            return i;
        }
    },
    Constants_B{
        public String getDescription() {
            return ("我是枚举类型B");
        }
        public int getI() {
            return i;
        }
    },
    Constants_C{
        public String getDescription() {
            return ("我是枚举类型C");
        }
        public int getI() {
            return i;
        }
    },
    Constants_D{
        public String getDescription() {
            return ("我是枚举类型D");
        }
        public int getI() {
            return i;
        }
    };
    private static int i = 5;
    public static void main(String args[]) {
        for (int i = 0; i < AnyEnum.values().length; i++) {
            System.out.println(AnyEnum.values()[i] + "调用getDescription()方法为:"  + AnyEnum.values()[i].getDescription());
            System.out.println(AnyEnum.values()[i] + "调用getI()方法为：" + AnyEnum.values()[i].getI());
        }
    }
}
