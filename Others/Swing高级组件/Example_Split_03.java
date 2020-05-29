package Swing高级组件;

import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Example_Split_03 extends JFrame {
    public Example_Split_03() {
        //调用父类的构造方法
        super();
        setTitle("设置桌面面板背景图片");
        setBounds(100, 100, 500, 375);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //创建桌面面板对象
        final JDesktopPane jDesktopPane = new JDesktopPane();
        //将桌面面板添加到适当位置
        getContentPane().add(jDesktopPane, BorderLayout.CENTER);
        //创建标签
        final JLabel backLabel = new JLabel();
        //将标签组件添加到指定的索引位置
        jDesktopPane.add(backLabel, new Integer(Integer.MIN_VALUE));
        URL resource = Example_Split_03.class.getResource("/主图5扣橘子.jpg");
        ImageIcon imageIcon = new ImageIcon(resource);
        //将背景图片添加到标签中
        backLabel.setIcon(imageIcon);
        //设置标签显示的位置和大小
        backLabel.setBounds(0, 0, imageIcon.getIconWidth(), imageIcon.getIconHeight());
    }
    public static void main(String args[]) {
        Example_Split_03 split_03 = new Example_Split_03();
        split_03.setVisible(true);
    }
}
