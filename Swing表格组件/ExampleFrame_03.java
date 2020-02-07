package Swing表格组件;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.Vector;

public class ExampleFrame_03 extends JFrame {
    public ExampleFrame_03() {
        //调用父类的构造方法
        super();
        setTitle("定义表格");
        setBounds(100, 100, 240, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JScrollPane jScrollPane = new JScrollPane();
        getContentPane().add(jScrollPane, BorderLayout.CENTER);
        //定义表头
        String[] columnNames = {"A", "B", "C", "D", "E", "F", "G"};
        Vector<String> columnNameV = new Vector<>();
        for (int column = 0; column < columnNames.length; column++) {
            columnNameV.add(columnNames[column]);
        }
        Vector<Vector<String>> tableValueV = new Vector<>();
        for (int row = 1; row <= 21; row++) {
            Vector<String> rowV = new Vector<>();
            for (int column = 0; column < columnNames.length; column++) {
                rowV.add(columnNames[column] + row);
            }
            tableValueV.add(rowV);
        }
        JTable jTable = new JTable(tableValueV,columnNameV);
        //关闭表格的自动调整功能
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //选择模式为单选
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //被选择行的背景颜色为黄色
        jTable.setSelectionBackground(Color.YELLOW);
        //被选择行的前景色（文字颜色）为红色
        jTable.setSelectionForeground(Color.RED);
        //表格的行高为30像素
        jTable.setRowHeight(30);
        jScrollPane.setViewportView(jTable);
    }
    //实现自己的表格类
    private class MTable extends JTable {
        public MTable(Vector<Vector<String>> rowData, Vector<String> columnNames) {
            super(rowData, columnNames);
        }
        //定义表格头
        @Override
        public JTableHeader getTableHeader() {
            //获得表格头对象
            JTableHeader jTableHeader = super.getTableHeader();
            //设置表格列不可重排
            tableHeader.setReorderingAllowed(false);
            //获得表格头的单元格对象
            DefaultTableCellRenderer hr = (DefaultTableCellRenderer)
                    tableHeader.getDefaultRenderer();
            //设置列名居中显示
            hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
            return tableHeader;
        }
        //定义单元格
        @Override
        public TableCellRenderer getDefaultRenderer(Class<?> columnClass) {
            //获得表格的单元格对象
            DefaultTableCellRenderer cr = (DefaultTableCellRenderer)
                    super.getDefaultRenderer(columnClass);
            //设置单元格内容居中显示
            cr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
            return cr;
        }
        //表格不可编辑
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }
    public static void main(String args[]) {
        ExampleFrame_03 frame_03 = new ExampleFrame_03();
        frame_03.setVisible(true);
    }
}
