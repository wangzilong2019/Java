package Swing高级组件;

import javax.swing.*;
import java.awt.*;

public class Example_Split_01 extends JFrame {
    public Example_Split_01() {
        //调用父类构造方法
        super();
        setTitle("使用分割面板");
        setBounds(100,100,500,375);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //创建水平分割面板
        final JSplitPane hSplitPane = new JSplitPane();
        //将水平面板添加到适当位置
        getContentPane().add(hSplitPane, BorderLayout.CENTER);
        //设置左侧宽度为40像素
        hSplitPane.setDividerLocation(40);
        //为左侧面板添加组件
        hSplitPane.setLeftComponent(new JLabel("   1"));
        //创建垂直分割面板
        final JSplitPane vSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        //将垂直分割面板添加到右侧
        hSplitPane.setRightComponent(vSplitPane);
        //设置分隔条上方宽度30像素
        vSplitPane.setDividerLocation(30);
        //设置分隔条宽度
        vSplitPane.setDividerSize(8);
        //垂直面板重绘方式为连续
        vSplitPane.setContinuousLayout(true);
        //在垂直面板上方下方分别添加组件
        vSplitPane.setLeftComponent(new JLabel("   2"));
        vSplitPane.setRightComponent(new JLabel("   3"));

    }
    public static void main(String args[]) {
        Example_Split_01 split_01 = new Example_Split_01();
        split_01.setVisible(true);
    }
}
