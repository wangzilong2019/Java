package com.guigu.tree;

public class BinaryTreeDemo {
    public static void main (String args[]) {
        //首先创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();

        //创建节点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");

        //手动创建二叉树
        binaryTree.setRoot(root);
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);

        System.out.println("前序遍历");
        binaryTree.preOrder();

//        //前序遍历查找
//        System.out.println("前序遍历查找————");
//        HeroNode resNode = binaryTree.preOrderSearch(4);
//        if (resNode != null) {
//            System.out.printf("找到该节点，信息为：id = %d name = %s", resNode.getId(), resNode.getName());
//        } else {
//            System.out.printf("没有找到 该节点");
//        }

//        //中序遍历查找
//        System.out.println("种序遍历查找————");
//        HeroNode resNode = binaryTree.inFixOrderSearch(4);
//        if (resNode != null) {
//            System.out.printf("找到该节点，信息为：id = %d name = %s", resNode.getId(), resNode.getName());
//        } else {
//            System.out.printf("没有找到 该节点");
//        }

//        //后序遍历查找
//        System.out.println("后序遍历查找————");
//        HeroNode resNode = binaryTree.postOrderSearch(4);
//        if (resNode != null) {
//            System.out.printf("找到该节点，信息为：id = %d name = %s", resNode.getId(), resNode.getName());
//        } else {
//            System.out.printf("没有找到 该节点");
//        }

        //节点删除测试
        binaryTree.delNode(4);
        System.out.println("删除后前序遍历结果：");
        binaryTree.preOrder();

    }
}

//创建二叉树
class BinaryTree{
    private HeroNode root;  //指针指向根节点

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder() {
        //当前根节点不为空时
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("当前二叉树为空");
        }
    }

    //中序遍历
    public void inFixOrder() {
        //当前根节点不为空时
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("当前二叉树为空");
        }
    }

    //后序遍历
    public void postOrder() {
        //当前根节点不为空时
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("当前二叉树为空");
        }
    }

    //前序遍历查找
    public HeroNode preOrderSearch(int id) {
        //当前根节点不为空
        if (root != null) {
            return root.preOrderSearch(id);
        } else {
            return null;
        }
    }

    //中序遍历查找
    public HeroNode inFixOrderSearch(int id) {
        //当前根节点不为空
        if (root != null) {
            return root.inFixOrderSearch(id);
        } else {
            return null;
        }
    }

    //后序遍历查找
    public HeroNode postOrderSearch(int id) {
        //当前根结不为空
        if (root != null) {
            return root.postOrderSearch(id);
        } else {
            return null;
        }
    }

    //删除节点
    public void delNode (int id) {
        //当树存在时
        if (root != null) {
            //判断当前根节点是否为待删除结点,，若是则直接删除
            if (root.getId() == id) {
                root = null;
            } else {
                root.delNode(id);
            }
        } else {
            System.out.println("树为空");
        }
    }

}

//创建节点
class HeroNode{
    private int id;
    private String name;
    private HeroNode left; //指针指向左节点
    private HeroNode right; //指针指向右节点

    //节点构造器
    public HeroNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //前序遍历二叉树
    public void preOrder() {
        System.out.println(this);  //输出当前节点
        //左节点不为空
        if (left != null) {
            left.preOrder();
        }
        //右节点不为空
        if (right != null) {
            right.preOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        //左节点不为空
        if (this.left != null) {
            this.left.postOrder();
        }
        //右节点不为空
        if (this.right != null) {
            this.right.postOrder();
        }
        //输出当前根节点
        System.out.println(this);
    }

    //中序遍历
    public void inFixOrder() {
        //左节点不为空
        if (this.left != null) {
            this.left.inFixOrder();
        }
        //输入当前根节点
        System.out.println(this);
        //右节点不为空
        if (this.right != null) {
            this.right.inFixOrder();
        }
    }

    //前序遍历找到该节点
    public HeroNode preOrderSearch (int id) {
        System.out.printf("dddd\n");  //记录查询次数
        //当前节点为待查找节点则返回
        if (this.id == id) {
            return this;
        }

        HeroNode node = null;
        //判断当前节点的左子节点是否为空，不为空时
        if (this.left != null) {
            node = this.left.preOrderSearch(id);
        }
        //判断是否找到
        if (node != null) {  //找到
            return node;
        }
        //在左子节点没有找到,，右子节点不为空时，则递归前序查找
        if (this.right != null) {
            node = this.right.preOrderSearch(id);
        }
        return node;
    }

    //中序遍历查找结点
    public HeroNode inFixOrderSearch(int id) {
        //判断当前节点左子节点是否为空，不为空，则左递归遍历
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.inFixOrderSearch(id);
        }
        //找到则直接返回
        if (resNode != null) {
            return resNode;
        }
        System.out.println("ddd");  //记录查询次数
        //当前节点左子节点没有找到，ze判断当前节点是否为是,
        if (this.id == id) {
            return this;
        }
        //当前节点没有找到，判断右子节点是否为空不为空则继续中序递归遍历
        if (this.right != null) {
            resNode = this.right.inFixOrderSearch(id);
        }
        //若在右子节点中找到，则返回右子节点，否则返回null
        return resNode;
    }

    //后序遍历找到节点
    public HeroNode postOrderSearch (int id) {
        //判断当前节点左子节点是否为空，不为空，ze左递归后序遍历
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(id);
        }
        //若找到则直接返回该节点
        if (resNode != null) {
            return resNode;
        }
        //没有找到，判断右子节点是否为i空，不为空则在右子节点种查找
        if (this.right != null) {
            resNode = this.right.postOrderSearch(id);
        }
        //判断在右子节点中是否扎到，找到则直接 返回
        if (resNode != null) {
            return resNode;
        }
        System.out.println("ddd");  //记录查询次数
        //判断当节点是否为
        if (this.id == id) {
            return this;
        }
        //都没找到
        return resNode;
    }

    //二叉树删除节点
    //若删除节点为叶子节点，则直接删除
    //若删除节点为非叶子节点，则删除子树
    public void delNode (int id) {
        //如果当前叶子节点存在且为待删除节点
        if (this.left != null && this.left.id == id) {
            this.left = null;
            return;
        }
        //若当前节点右子节点存在且为待删除节点
        if (this.right != null && this.right.id == id) {
            this.right = null;
            return;
        }
        //若待删除节点为非叶子节点，则需要左子树递归删除
        if (this.left != null) {
            this.left.delNode(id);
        }
        if (this.right != null) {
            this.right.delNode(id);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }
    public HeroNode getLeft() {
        return left;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }
    public HeroNode getRight() {
        return right;
    }

    public String toString() {
        return "HeroNode [no=" + id + ", name=" + name + "]";
    }
}
