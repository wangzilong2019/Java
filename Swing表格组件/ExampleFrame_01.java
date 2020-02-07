package Swing表格组件;

import javax.swing.*;
import java.awt.*;

public class ExampleFrame_01  extends JFrame {
    public ExampleFrame_01() {
        //调用父类的构造方法
        super();
        setTitle("创建可以带滚动条的表格");
        setBounds(100,100,240,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //定义表格列名数组
        String[] columnNames = {"A", "B"};
        //定义表格数据数组
        String[][] tableNames = {{"A1", "B1"},{"A2", "B2"},{"A3", "B3"},
                {"A4", "B4"},{"A5", "B5"},{"A6", "B6"},{"A7", "B7"}};
        //创建指定列名和数据的表格
        JTable jTable = new JTable(tableNames,columnNames);
        //创建显示表格的滚动面板
        JScrollPane jScrollPane = new JScrollPane(jTable);
        //将滚动面板添加到滚动布局的中间
        getContentPane().add(jScrollPane, BorderLayout.CENTER);
    }
    public static void main(String args[]) {
        ExampleFrame_01 frame_01 = new ExampleFrame_01();
        frame_01.setVisible(true);
    }
}
