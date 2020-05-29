package Swing高级组件;

import javax.swing.*;
import java.awt.*;

public class Example_ToolBar_01 extends JFrame {
    public Example_ToolBar_01() {
        //调用父类的构造方法
        super();
        setTitle("创建工具栏");
        setBounds(100, 100, 500, 375);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //创建工具栏
        final JToolBar jToolBar = new JToolBar("工具栏");
        //设置为不允许拖动
        jToolBar.setFloatable(false);
        //添加到合适位置
        getContentPane().add(jToolBar, BorderLayout.NORTH);
        //创建新建按钮对象
        final JButton newButton = new JButton("新建");
        //添加到工具栏中
        jToolBar.add(newButton);
        //设置默认大小的分隔符
        jToolBar.addSeparator();
        //创建保存按钮对象
        final JButton saveButton = new JButton("保存");
        //添加到工具栏中
        jToolBar.add(saveButton);
        //设置指定大小的分隔符
        jToolBar.addSeparator(new Dimension(10,0));
        //创建退出按钮对象
        final JButton exitButton = new JButton("退出");
        //添加到工具栏中
        jToolBar.add(exitButton);
    }
    public static void main(String srgs[]) {
        Example_ToolBar_01 toolBar_01 = new Example_ToolBar_01();
        toolBar_01.setVisible(true);
    }
}
