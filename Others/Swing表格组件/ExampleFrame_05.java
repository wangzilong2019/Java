package Swing表格组件;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;

public class ExampleFrame_05 extends JFrame {
    //声明各对象
    private DefaultTableModel tableModel;
    private JTable jTable;
    private JTextField aTextField;
    private JTextField bTextField;
    public ExampleFrame_05() {
        //调用父类的构造方法
        super();
        setTitle("操纵表格");
        setBounds(100,100,510,375);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //创建表格模板
        final JScrollPane jScrollPane = new JScrollPane();
        //将表格模板添加到适当位置
        getContentPane().add(jScrollPane, BorderLayout.CENTER);
        //定义表格列名数组
        String[] columnNames = {"A", "B"};
        //定义表格数据数组
        String[][] tableValues = {{"A1", "B1"}, {"A2", "B2"}};
        //创建表格模型
        tableModel = new DefaultTableModel(tableValues, columnNames);
        //创建表格模型表格
        jTable = new JTable(tableModel);
        //设置排序器
        jTable.setRowSorter(new TableRowSorter<>(tableModel));
        //设置表格选择模式为单选

        //为表格添加鼠标事件监视器
        jTable.addMouseListener(new MouseAdapter() {
            //发生了单击事件
            public void mouseClicked(MouseEvent e) {
                //获得被选中的索引值
                int selectRoe = jTable.getSelectedRow();
                //获得表格模型中指定单元格的值
                Object oa = tableModel.getValueAt(selectRoe, 0);
                Object ob = tableModel.getValueAt(selectRoe, 1);
                //将值赋给文本域
                aTextField.setText(oa.toString());
                bTextField.setText(ob.toString());
            }
        });
        jScrollPane.setViewportView(jTable);
        //创建底部面板
        final JPanel jPanel = new JPanel();
        //将面板添加到容器适当位置
        getContentPane().add(jPanel, BorderLayout.SOUTH);
        jPanel.add(new JLabel("A:"));
        aTextField = new JTextField("A4", 10);
        jPanel.add(aTextField);
        jPanel.add(new JLabel("B:"));
        bTextField = new JTextField("B4", 10);
        jPanel.add(bTextField);
        //创建添加按钮
        final JButton addButton = new JButton("添加");
        //设置单击事件
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //创建表格行数组
                String[] rowValues = {aTextField.getText(), bTextField.getText()};
                //想表格模型中添加一行
                tableModel.addRow(rowValues);
                int rowCount = jTable.getRowCount() + 1;
                aTextField.setText("A" + rowCount);
                bTextField.setText("B" + rowCount);
            }
        });
        jPanel.add(addButton);
        final JButton updButton = new JButton("修改");
        updButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //获取被选中行的索引
                int selectedRoe = jTable.getSelectedRow();
                //判断是否存在选中行
                if (selectedRoe != -1) {
                    //修改表格模型中的指定值
                    tableModel.setValueAt(aTextField.getText(), selectedRoe, 0);
                    tableModel.setValueAt(bTextField.getText(), selectedRoe, 1);
                }
            }
        });
        jPanel.add(updButton);
        final JButton delButton = new JButton("删除");
        delButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //获得被选中的索引
                int selectedRow = jTable.getSelectedRow();
                //判断是否存在选中行
                if (selectedRow != -1) {
                    tableModel.removeRow(selectedRow);
                }
            }
        });
    }
    public static void main(String args[]) {
        ExampleFrame_05 frame_05 = new ExampleFrame_05();
        frame_05.setVisible(true);
    }

}
