package Swing树组件;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;

public class CreatTree_E extends JFrame {
    public CreatTree_E() {
        setTitle("三种创建树的方式");
        setBounds(100,100,240,150);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //创建根结点
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("根结点");
        //创建一级节点
        DefaultMutableTreeNode nodeFirst = new DefaultMutableTreeNode("一级子节点A");
        //将一级节点添加到根结点
        root.add(nodeFirst);
        //创建不允许有子节点的二级节点
        DefaultMutableTreeNode nodeSecond = new DefaultMutableTreeNode("二级子节点", false);
        //将二级节点添加到一级节点
        nodeFirst.add(nodeSecond);
        //创建一级节点B
        root.add(new DefaultMutableTreeNode("一级子节点B"));
        //利用根结点创建树
        JTree treeRoot = new JTree(root);
        getContentPane().add(treeRoot, BorderLayout.WEST);
        //利用根结点创建树模型，采用默认方式判断
        DefaultTreeModel treeModel = new DefaultTreeModel(root);
        //利用树模型创建树
        JTree treeDefault = new JTree(treeModel);
        getContentPane().add(treeDefault, BorderLayout.CENTER);
        //才用根结点创建树模型，并采用非默认的方式判断
        DefaultTreeModel treeModelPointed = new DefaultTreeModel(root, true);
        //创建树
        JTree treePointed = new JTree(treeModelPointed);
        getContentPane().add(treePointed, BorderLayout.EAST);
    }
    public static void main(String args[]) {
        new CreatTree_E();
    }
}
