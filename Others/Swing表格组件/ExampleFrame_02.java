package Swing表格组件;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.Vector;

public class ExampleFrame_02 extends JFrame {
    public ExampleFrame_02() {
        //调用父类的构造方法
        super();
        setTitle("创建不带滚动条的表格");
        setBounds(100,100,240,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //定义表格列名向量
        Vector<String> columnNameV = new Vector<>();
        //添加列名
        columnNameV.add("A");
        columnNameV.add("B");
        //定义表格数据向量
        Vector<Vector<String>> tableValueV = new Vector<>();
        for (int row = 1; row <= 6; row++) {
            //定义表格行向量
            Vector<String> rowV = new Vector<>();
            //添加单元格数据
            rowV.add("A" + row);
            rowV.add("B" + row);
            //将表格的行向量添加到数据向量中
            tableValueV.add(rowV);
        }
        //创建指定表格的列名和表格数据的表格
        JTable jTable = new JTable(tableValueV, columnNameV);
        //将表格添加到页面布局的中间
        getContentPane().add(jTable, BorderLayout.CENTER);
        //获取表格头对象
        JTableHeader jTableHeader = jTable.getTableHeader();
        //将表头添加到页面布局的上方
        getContentPane().add(jTableHeader,BorderLayout.NORTH);

    }
    public static void main(String args[]) {
        ExampleFrame_02 frame_02 = new ExampleFrame_02();
        frame_02.setVisible(true);
    }
}
