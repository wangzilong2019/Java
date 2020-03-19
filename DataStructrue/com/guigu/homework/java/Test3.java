package homework.java;

public class Test3 {
    public static void main (String args[]) {
        //创建Test3类对象
        Test3 test3 = new Test3();
        //调用用户自定义子方法
        test3.hello();
    }
    //编写用户子函数，功能为输出hello,world!
    public static void hello() {
        System.out.printf("hello,world!");
    }
}
