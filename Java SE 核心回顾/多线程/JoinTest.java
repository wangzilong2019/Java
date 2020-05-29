package 多线程;

import javax.swing.*;
import java.awt.*;

public class JoinTest extends JFrame {
    //定义俩个线程
    private Thread threadA;
    private Thread threadB;
    //定义俩个进度条
    final JProgressBar jProgressBar = new JProgressBar();
    final JProgressBar jProgressBar2 = new JProgressBar();
    int count = 0;
    public JoinTest() {
        super();
        //将进度条分别设置在窗体的最上面和最下面
        Container c = getContentPane();
        c.add(jProgressBar,BorderLayout.NORTH);
        c.add(jProgressBar2,BorderLayout.SOUTH);
        //设置进度条显示数字字符
        jProgressBar.setStringPainted(true);
        jProgressBar2.setStringPainted(true);
        //使用匿名内部类定义形式初始化Thread实例
        threadA = new Thread(new Runnable() {
            int count = 0;
            @Override
            public void run() {
                while (true) {
                    //设置进度条当前值
                    jProgressBar.setValue(++count);
                    try {
                        //使线程A休眠100毫秒
                        Thread.sleep(100);
                        //调用join()方法使线程B加入
                        threadB.join();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        //启动线程A
        threadA.start();
        threadB = new Thread(new Runnable() {
            int count = 0;
            @Override
            public void run() {
                while (true) {
                    //设置当前进度条的值
                    jProgressBar2.setValue(++count);
                    try {
                        //使线程B休眠100毫秒
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (count == 100) {
                        break;
                    }
                }
            }
        });
        threadB.start();
    }
    public static void init(JFrame jFrame, int width, int high) {
        jFrame.setSize(width, high);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
    public static void main(String args[]) {
        init(new JoinTest(), 100, 100);
    }
}
