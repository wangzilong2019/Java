package AWT绘图与音频播放;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class DrawFrame extends JFrame {
    public DrawFrame() {
        //调用父类的构造方法
        super();
        //调用初始化方法
        initialize();
    }
    //初始化方法
    private void initialize() {
        //设置窗体大小
        this.setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new Canvas());
        this.setTitle("绘制图例2");
    }
    class CanvasPanel extends Panel {
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2 = (Graphics2D) g;
            //声明图形数组
            Shape[] shapes = new Shape[4];
            //创建图形对象
            shapes[0] = new Ellipse2D.Double(5, 5, 100, 100);
            //创建矩形数组
            shapes[1] = new Rectangle2D.Double(110, 5, 100, 100);
            //创建矩形数组
            shapes[2] = new Rectangle2D.Double(15, 15, 80, 80);
            //创建图形数组
            shapes[3] = new Ellipse2D.Double(120, 15, 80, 80);
            for (Shape shape : shapes) {
                Rectangle2D bounds = shape.getBounds2D();
                if (bounds.getWidth() == 60) {
                    g2.fill(shape);
                }
                else {
                    g2.draw(shape);
                }
            }

        }
    }
    public static void main(String args[]) {
        new DrawFrame().setVisible(true);
    }
}
