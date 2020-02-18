package AWT绘图与音频播放;

import javax.swing.*;
import java.awt.*;

public class DrawCircle extends JFrame {
    //定义圆形的宽和高
    private final int OVAL_WIDTH = 80;
    private final int OVAL_HEIGHT = 80;
    public DrawCircle() {
        //调用父类方法
        super();
        //调用初始化方法
        initialize();
    }
    //初始化方法
    private void initialize() {
        //设置窗体大小
        this.setSize(300, 200);
        //设置窗体关闭方式
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗体面板为绘图面板对象
        setContentPane(new DrawPanel());
        //设置标题
        this.setTitle("绘图实例");
    }
    //创建绘图面板
    class DrawPanel extends JPanel {
        public void paint(Graphics g) {
            super.paint(g);
            //分别绘制图形
            g.drawOval(10, 10, OVAL_WIDTH, OVAL_HEIGHT);
            g.drawOval(80, 10, OVAL_WIDTH, OVAL_HEIGHT);
            g.drawOval(150, 10, OVAL_WIDTH, OVAL_HEIGHT);
            g.drawOval(50, 70, OVAL_WIDTH, OVAL_HEIGHT);
            g.drawOval(120, 70, OVAL_WIDTH, OVAL_HEIGHT);
        }
    }
    public static void main(String args[]) {
        new DrawCircle().setVisible(true);
    }
}
