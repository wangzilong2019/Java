package homework.java;

public class PlateNumber {
    public static void main (String args[]) {
        //定义三个字符变量变量来表示前三个字母
        //调用随机函数来生成
        char randomCharA = (char) ('A' + Math.random()*('Z' - 'A' + 1));
        char randomCharB = (char) ('A' + Math.random()*('Z' - 'A' + 1));
        char randomCharC = (char) ('A' + Math.random()*('Z' - 'A' + 1));
        //定义一个整数来表示后四位数
        int lastNumber = (int) (1000 +  Math.random()*9000);
        //输入随机抽取的车牌号
        System.out.printf("%c%c%c%d",randomCharA,randomCharB,randomCharC,lastNumber);
    }
}
