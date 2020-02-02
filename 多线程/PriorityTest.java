package 多线程;

import javax.swing.*;
import java.awt.*;

public class PriorityTest extends JFrame {
    //定义四个线程
    private Thread threadA;
    private Thread threadB;
    private Thread threadC;
    private Thread threadD;
    //定义四个进度条
    final JProgressBar jProgressBarA = new JProgressBar();
    final JProgressBar jProgressBarB = new JProgressBar();
    final JProgressBar jProgressBarC = new JProgressBar();
    final  JProgressBar jProgressBarD = new JProgressBar();
    int count = 0;
    public PriorityTest() {
        super();
        //定义一个容器
        Container c = getContentPane();
        //设置进度条可用数字字符
        jProgressBarA.setStringPainted(true);
        jProgressBarB.setStringPainted(true);
        jProgressBarC.setStringPainted(true);
        jProgressBarD.setStringPainted(true);
        //设置进度条在窗体中的位置
        c.add(jProgressBarA,BorderLayout.NORTH);
        c.add(jProgressBarB,BorderLayout.EAST);
        c.add(jProgressBarC,BorderLayout.WEST);
        c.add(jProgressBarD,BorderLayout.SOUTH);
        //分别实例化四个线程
        threadA = new Thread(new MyThread(jProgressBarA));
        threadB = new Thread(new MyThread(jProgressBarB));
        threadC = new Thread(new MyThread(jProgressBarC));
        threadD = new Thread(new MyThread(jProgressBarD));
        setPriority("threadA",5,threadA);
        setPriority("threadB",5,threadB);
        setPriority("threadC",4,threadC);
        setPriority("threadD",3,threadD);
    }
    public static void setPriority(String threadName, int priority, Thread t) {
        //设置线程的名称，优先级，启动线程
        t.setName(threadName);
        t.setPriority(priority);
        t.start();
    }
    //定义一个实现Runnable接口的类
    private final class MyThread implements Runnable{
        private final JProgressBar bar;
        int count = 0;
        private MyThread(JProgressBar bar) {
            this.bar = bar;
        }
        //重写run()方法
        public void run() {
            while (true) {
                //设置滚动条每次递增10
                bar.setValue(count +=10);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("当前线程被中断");
                }
            }
        }
    }
    public static void init(JFrame jFrame, int width, int high) {
        jFrame.setSize(width, high);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String args[]) {
        init(new PriorityTest(),100,10);
    }

}
