package 枚举类型与泛型;

import javax.swing.plaf.PanelUI;

public class ShowEnum {
    enum Constants2 {
        Constants_A,
        Constants_B
    }
    public static void main(String args[]) {
        //循环由values()方法返回的数组
        for (int i = 0 ; i < Constants2.values().length ; i++) {
            //将枚举成员变量打印
            System.out.println(Constants2.values()[i]);
        }
    }
}
