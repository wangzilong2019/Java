package Swing树组件;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.util.Enumeration;

public class Example_01  extends JFrame {
    public Example_01() {
        //调用父类的构造方法
        super();
        setTitle("定制树");
        setBounds(100,100,240,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //创建根结点
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("根结点");
        //创建一级子节点
        DefaultMutableTreeNode nodeFirst = new DefaultMutableTreeNode("人事管理");
        DefaultMutableTreeNode nodeFirst2 = new DefaultMutableTreeNode("待遇管理");
        DefaultMutableTreeNode nodeFirst3 = new DefaultMutableTreeNode("系统维护");
        //将一级子节点加入根结点
        root.add(nodeFirst);
        root.add(nodeFirst2);
        root.add(nodeFirst3);
        //创建二级子节点
        DefaultMutableTreeNode nodeSecond = new DefaultMutableTreeNode("二级A");
        DefaultMutableTreeNode nodeSecond2 = new DefaultMutableTreeNode("二级B");
        DefaultMutableTreeNode nodeSecond3 = new DefaultMutableTreeNode("二级C");
        DefaultMutableTreeNode nodeSecond4 = new DefaultMutableTreeNode("二级D");
        //将二级节点加入一级节点
        nodeFirst.add(nodeSecond);
        nodeFirst.add(nodeSecond2);
        nodeFirst.add(nodeSecond3);
        nodeFirst2.add(nodeSecond);
        nodeFirst2.add(nodeSecond2);
        nodeFirst2.add(nodeSecond3);
        nodeFirst2.add(nodeSecond4);
        nodeFirst3.add(nodeSecond);
        nodeFirst3.add(nodeSecond2);
        nodeFirst3.add(nodeSecond3);
        //根结根结点创建树
        JTree jTree = new JTree(root);
        getContentPane().add(jTree);
        //不显示根节点
        jTree.setRootVisible(false);
        //设置行高
        jTree.setRowHeight(20);
        //设置字体
        jTree.setFont(new Font("宋体",Font.BOLD,14));
        //获得树节点绘制对象
        DefaultTreeCellRenderer treeCellRenderer = (DefaultTreeCellRenderer) jTree.getCellRenderer();
        //设置叶子节点不设置图标
        treeCellRenderer.setLeafIcon(null);
        //设置节点折叠和展开时不采用图标
        treeCellRenderer.setClosedIcon(null);
        treeCellRenderer.setOpenIcon(null);
        //按前序遍历所有树节点
        Enumeration<?> enumeration;
        enumeration = root.preorderEnumeration();
        while (enumeration.hasMoreElements()) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) enumeration.nextElement();
            //判断是否为叶子节点
            if (!node.isLeaf()) {
                //创建该节点的对象
                TreePath treePath = new TreePath(node.getPath());
                //如果不是，则展开该节点
                jTree.expandPath(treePath);
            }
        }
    }
    public static void main(String agrs[]) {
        Example_01 example_01 = new Example_01();
        example_01.setVisible(true);
    }
}
