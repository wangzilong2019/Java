package 多线程;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SleepMethodTest extends JFrame {
    private Thread t;
    //定义颜色数组
    private static Color[] colors = {Color.BLACK,Color.BLUE,Color.CYAN,
            Color.GREEN,Color.ORANGE,Color.YELLOW,Color.RED,Color.PINK,Color.LIGHT_GRAY};
    //创建随机对象
    private static final Random random = new Random();
    //获取随机颜色值得方法
    private static Color getC() {
        return colors[random.nextInt(colors.length)];
    }
    public SleepMethodTest() {
        //创建匿名类线程对象
        t = new Thread(new Runnable() {
            //定义初始坐标
            int x = 30;
            int y = 50;
            @Override
            //覆盖线程接口方法
            public void run() {
                while (true) {
                    try {
                        //使线程休眠1秒
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //获取组件绘图上下文的对象
                    Graphics graphics = getGraphics();
                    //设置绘图yanse
                    graphics.setColor(getC());
                    //绘制直线并递增垂直坐标
                    graphics.drawLine(x, y, 100, y++);
                    if (y >= 80) {
                        y = 50;
                    }
                }
            }
        });
    }
    public static void Init(JFrame jFrame, int width, int high) {
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setSize(width, high);
        jFrame.setVisible(true);
    }
    public static void main(String args[]) {
        Init(new SleepMethodTest(),100,100);
    }
}
