package homework.java;

import java.util.Scanner;

public class HexagonArea {
    public static void main (String args[]) {
        //创建一个Scanner类对象
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the side : ");
        //定义六边形的边长
        float s = input.nextFloat();
        //计算六边形面积
        double area = (6*s*s) / (4*Math.tan(Math.PI/6));
        System.out.printf("The area of the hexagon is %.2f",area);
    }
}
