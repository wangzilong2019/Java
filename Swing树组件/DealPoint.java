package Swing树组件;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

public class DealPoint extends JFrame {
    public DealPoint() {
        setTitle("处理树节点事件");
        setBounds(100, 100, 240, 150);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //创建根结点
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("根结点");
        //创建一级子节点A
        DefaultMutableTreeNode nodeFirst = new DefaultMutableTreeNode("一级子节点A");
        //将一级子节点接入根结点
        root.add(nodeFirst);
        root.add(new DefaultMutableTreeNode("一级子节点B"));
        //创建二级子节点
        DefaultMutableTreeNode nodeSecond = new DefaultMutableTreeNode("二级子节点", false);
        //将二级子节点加入一级子节点A
        nodeFirst.add(nodeSecond);
        //利用根结点创建树
        JTree tree = new JTree(root);
        getContentPane().add(tree);
        //获得数的选择模型
        TreeSelectionModel treeSelectionModel = tree.getSelectionModel();
        //设置树的选择模型为单选
        treeSelectionModel.setSelectionMode(TreeSelectionModel.CONTIGUOUS_TREE_SELECTION);
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                //查看是否有备选中的节点
                if ( !tree.isSelectionEmpty()) {
                    //获得被选节点的路径
                    TreePath[] treePaths = tree.getSelectionPaths();
                    for (int i = 0; i < treePaths.length; i++) {
                        //获得被选节点的路径
                        TreePath treePath = treePaths[i];
                        //以Object数组形式返回该路径中所有节点的对象
                        Object[] path = treePath.getPath();
                        for (int j = 0; j < path.length; j++) {
                            //获得节点
                            DefaultMutableTreeNode node = (DefaultMutableTreeNode) path[i];
                            String s = node.getUserObject() + (j == (path.length-1) ? "" : "->");
                            System.out.println(s);
                        }
                        System.out.println();
                    }
                    System.out.println();
                }
            }
        });
    }
    public static void main(String args[]) {
        new DealPoint();
    }
}
