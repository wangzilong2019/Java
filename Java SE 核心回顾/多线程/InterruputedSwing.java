package 多线程;

import javax.swing.*;
import java.awt.*;

public class InterruputedSwing extends JFrame {
    //定义一个进程
    Thread thread;
    public InterruputedSwing() {
        super();
        //定义一个进度条
        final JProgressBar jProgressBar = new JProgressBar();
        //定义一个容器
        Container c = getContentPane();
        //设置进度条上的数字
        jProgressBar.setStringPainted(true);
        //将进度条放置在容器的适当位置
        c.add(jProgressBar,BorderLayout.NORTH);
        thread = new Thread(new Runnable() {
            int count = 0;
            @Override
            public void run() {
                while (true) {
                    //设置当前进度条的值
                    jProgressBar.setValue(++count);
                    try {
                        thread.sleep(1000);
                        //捕捉InterruptedException异常
                    } catch (InterruptedException e) {
                        System.out.println("当前程序被中断");
                        break;
                    }
                }
            }
        });
        //启动线程
        thread.start();
        //中断线程
        thread.interrupt();
    }
    //初始化窗体
    public static void init(JFrame jFrame, int width, int high) {
        jFrame.setSize(width, high);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String args[]) {
        init(new InterruputedSwing(),100,100);
    }


}
