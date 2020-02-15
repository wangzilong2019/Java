package Swing高级组件;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.net.URL;

public class Example_Split_02 extends JFrame {
    public Example_Split_02() {
        //调用父类的构造方法
        super();
        setTitle("选项卡面板");
        setBounds(100,100,500,375);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //创建选项卡面板对象
        final JTabbedPane jTabbedPane = new JTabbedPane();
        //将选项卡面板添加到适合位置
        getContentPane().add(jTabbedPane, BorderLayout.CENTER);
        //设置选项卡面板标签的布局方式
        jTabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        //为选项卡面板添加捕获事件
        jTabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                //获取被选中的选项卡面板索引
                int selectIndex = jTabbedPane.getSelectedIndex();
                //获取指定索引的选项卡标签
                String title = jTabbedPane.getTitleAt(selectIndex);
                System.out.println(title);
            }
        });
       // URL resource = Example_Split_02.class.getResource("/主图5扣橘子.jpg");
       // ImageIcon imageIcon = new ImageIcon(resource);
        final JLabel jLabelA = new JLabel();
        jLabelA.setText("选项卡A");
        jTabbedPane.addTab("选项卡A", null, jLabelA, "点击查看选项卡A");
        final JLabel jLabelB = new JLabel();
        jLabelB.setText("选项卡B");
        jTabbedPane.addTab("选项卡B", null, jLabelB, "点击查看选项卡B");
        final JLabel jLabelC = new JLabel();
        jLabelC.setText("选项卡C");
        jTabbedPane.addTab("选项卡C", null, jLabelC, "点击查看选项卡C");
        //设置索引为2的选项卡被选中
        jTabbedPane.setSelectedIndex(2);
        //设置索引为0的选项卡不可选
        jTabbedPane.setEnabledAt(0, false);
    }
    public static void main(String args[]) {
        Example_Split_02 split_02 = new Example_Split_02();
        split_02.setVisible(true);
    }
}
