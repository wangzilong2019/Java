package Swing表格组件;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class ExampleFrame_04 extends JFrame {
    public ExampleFrame_04() {
        //调用父类的构造方法
        super();
        setTitle("排序表格");
        setBounds(100,100,240,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JScrollPane jScrollPane = new JScrollPane();
        getContentPane().add(jScrollPane, BorderLayout.CENTER);
        //创建列名数组
        String[] columnNames = {"A", "B"};
        String[][] tableValues = {{"A1" ,"B1"},{"A2", "B2"},{"A3", "B3"}};
        //创建表格模型对象
        DefaultTableModel tableModel = new DefaultTableModel(tableValues, columnNames);
        //创建表格对象
        JTable jTable = new JTable(tableModel);
        jTable.setRowSorter(new TableRowSorter<>(tableModel));
        jScrollPane.setViewportView(jTable);
    }
    public static void main(String args[]) {
        ExampleFrame_04 frame_04 = new ExampleFrame_04();
        frame_04.setVisible(true);
    }
}
