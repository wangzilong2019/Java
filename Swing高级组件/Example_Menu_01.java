package Swing高级组件;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.ItemListener;

public class Example_Menu_01 extends JFrame {
    public Example_Menu_01() {
        //调用父类的构造方法
        super();
        setTitle("定制菜单");
        setBounds(100, 100, 500, 375);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //创建菜单栏
        final JMenuBar jMenuBar = new JMenuBar();
        //将菜单栏添加到合适位置
        getContentPane().add(jMenuBar, BorderLayout.NORTH);
        //创建文件菜单对象
        final JMenu fMenu = new JMenu("文件（F)");
        //将文件菜单项添加到菜单栏中
        jMenuBar.add(fMenu);
        //设置快捷键
        fMenu.setMnemonic('F');
        //创建新建菜单项
        final JMenuItem newItem = new JMenuItem("新建（N）");
        //将菜单添加到文件菜单中
        fMenu.add(newItem);
        //设置快捷键
        newItem.setMnemonic('N');
        //设置加速器
        newItem.setAccelerator(KeyStroke.getKeyStroke(VK_N, InputEvent.CTRL_MASK));
        //添加动作监听器
        newItem.addActionListener(new ItemListener());
        //创建打开子菜单
        final JMenu oMenu = new JMenu("打开（O）");
        //将打开子菜单添加到文件菜单中
        fMenu.add(oMenu);
        //设置快捷键
        oMenu.setMnemonic('O');
        //创建子菜单项
        final JMenuItem openNewItem = new JMenuItem("未打开过的（）");
        //将菜单项添加到子菜单
        oMenu.add(openNewItem);
        //设置快捷键
        openNewItem.setMnemonic('N');
        //设置加速器
        openNewItem.setAccelerator(KeyStroke.getKeyStroke(VK_N, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
        //添加动作监听器
        openNewItem.addActionListener(new ItemListener());
        //创建子菜单项
        final JMenuItem openCloseItem = new JMenuItem("已打开过的（C）");
        //将菜单项添加到打开子菜单
        oMenu.add(openCloseItem);
        //设置加速器
        openCloseItem.setAccelerator(KeyStroke.getKeyStroke(VK_C, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
        //设置快捷键
        openCloseItem.setMnemonic('C');
        //添加动作事件
        openCloseItem.addActionListener(new ItemListener());
        //禁用菜单项
        openCloseItem.setEnabled(false);
        //添加分割线
        fMenu.addSeparator();
        //创建编辑菜单
        final JMenu editMenu = new JMenu("编辑（E）");
        //设置快捷键
        editMenu.setMnemonic('E');
        //将编辑菜单加入到菜单栏
        jMenuBar.add(editMenu);
        //创建字体子菜单
        final JMenu fontMenu = new JMenu("字体（F）");
        //设置快捷键
        fontMenu.setMnemonic('F');
        //添加到编辑菜单
        editMenu.add(fontMenu);
        //创建复选框菜单项
        final JCheckBoxMenuItem bCheckBoxItem = new JCheckBoxMenuItem("加粗（B）");
        //设置快捷键
        bCheckBoxItem.setMnemonic('B');
        //设置加速器
        bCheckBoxItem.setAccelerator(KeyStroke.getKeyStroke(VK_B, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
        //添加动作监听器
        bCheckBoxItem.addActionListener(new ItemListener());
        //添加到字体子菜单
        fontMenu.add(bCheckBoxItem);
        //创建复选框菜单项
        final JCheckBoxMenuItem iCheckBoxItem = new JCheckBoxMenuItem("斜体（I）");
        //设置快捷键
        iCheckBoxItem.setMnemonic('I');
        //设置加速器
        iCheckBoxItem.setAccelerator(KeyStroke.getKeyStroke(VK_I, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
        //添加动作监听器
        iCheckBoxItem.addActionListener(new ItemListener());
        //添加爱字体子菜单
        fontMenu.add(iCheckBoxItem);

    }
    private class ItemListener implements ActionListener{
        public void actionPerformer(ActionEvent e) {
            //获取触发此次事件的菜单项
            JMenuItem menuItem = (JMenuItem) e.getSource();
            System.out.println("你单击的菜单项是：" + menuItem.getText());
        }
    }
    public static void main(String args[]) {
        Example_Menu_01 menu_01 = new Example_Menu_01();
        menu_01.setVisible(true);
    }
}

