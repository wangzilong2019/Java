package Swing表格组件;

import javax.swing.*;
import java.util.Vector;

public class MfixedColumnTable extends JPanel {
    //定义列名向量
    private Vector<String> columnNameV;
    //创建表格数据向量
    private Vector<Vector<Object>> tableValueV;
    //固定列数量
    private int fixedColumn = 1;
}

