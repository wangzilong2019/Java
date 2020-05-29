package 反射;

public class Example_04 {
    static void staticMethod(){
        System.out.println("执行staticMethod()方法");
    }
    public int publicMethod(int i) {
        System.out.println("执行publicMethod()方法");
        return i*100;
    }
    private String privateMethod(String...strings) {
        System.out.println("执行privateMethod()方法");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0 ; i < strings.length ; i++) {
            stringBuffer.append(strings[i]);
        }
        return stringBuffer.toString();
    }
}
