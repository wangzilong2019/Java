package Swing树组件;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Example_02 extends JFrame {
    public Example_02() {
        super();
        setTitle("维护树模型");
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
        //根结根结点创建树模型
        DefaultTreeModel treeModel = new DefaultTreeModel(root);
        //通过树模型创建树
        JTree jTree = new JTree(treeModel);
        //创建内容面板
        JScrollPane contentPane = new JScrollPane();
        contentPane.add(jTree);
        getContentPane().add(contentPane);
        //创建按钮面板
        JScrollPane buttonPane = new JScrollPane();
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        buttonPane.add(new JLabel("名称："));
        //创建文本域
        JTextField jTextField = new JTextField(10);
        buttonPane.add(jTextField);
        //创建添加按钮
        final JButton addButton = new JButton("添加");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //创建欲添加的节点
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(jTextField.getText());
                //获得选中的父节点路径
                TreePath treePath = jTree.getSelectionPath();
                //获得选中的父节点
                DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) treePath.getLastPathComponent();
                //插入节点到所有子节点之后
                treeModel.insertNodeInto(node, parentNode, parentNode.getChildCount());
                //获得新添加节点路径
                TreePath path = treePath.pathByAddingChild(node);
                //如果该节点不可见，则令其可见
                if ( !jTree.isVisible(path)) {
                    jTree.makeVisible(path);
                }
            }
        });
        buttonPane.add(addButton);
        final JButton updButton = new JButton("修改");
        updButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //获得所要修改节点的路径
                TreePath selectPath = jTree.getSelectionPath();
                //获得所要修改的节点
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) selectPath.getLastPathComponent();
                //修改节点的用户标签
                node.setUserObject(jTextField.getText());
                //通知树模型该节点已经被修改
                treeModel.nodeChanged(node);
                //选中被修改的节点
                jTree.setSelectionPath(selectPath);
            }
        });
        buttonPane.add(updButton);
        final JButton delButton = new JButton("删除");
        delButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //获得欲选中的删除的节点
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTree.getLastSelectedPathComponent();
                //查看要删除的节点是否为根结点，根节点不允许删除
                if ( !node.isRoot()) {
                    //获得下一个兄弟节点。以备选中
                    DefaultMutableTreeNode nextSelectedNode = node.getNextSibling();
                    //查看是否存在兄弟几点
                    if (nextSelectedNode == null) {
                        //如果不存爱则选中父节点
                        nextSelectedNode = (DefaultMutableTreeNode) node.getParent();
                        //删除结点
                        treeModel.removeNodeFromParent(node);
                        //选中节点
                        jTree.setSelectionPath(new TreePath(nextSelectedNode.getPath()));
                    }
                }
            }
        });
        buttonPane.add(delButton);

    }
    public static void main(String args[]) {
        Example_02 example_02 = new Example_02();
        example_02.setVisible(true);
    }
}
