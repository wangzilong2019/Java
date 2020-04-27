package com.guigu.tree.threadedBinaryTree;

public class ThreadedBinaryTreeDemo {
    public static void main (String args[]) {
        //创建节点
        HeroNode root = new HeroNode(1, "TOM");
        HeroNode heroNode2 = new HeroNode(3, "JACK");
        HeroNode heroNode3 = new HeroNode(6, "SIMITH");
        HeroNode heroNode4 = new HeroNode(8, "MARY");
        HeroNode heroNode5 = new HeroNode(10, "KING");
        HeroNode heroNode6 = new HeroNode(14, "DIM");

        root.setLeft(heroNode2);
        root.setRight(heroNode3);
        heroNode2.setLeft(heroNode4);
        heroNode2.setRight(heroNode5);
        heroNode3.setLeft(heroNode6);

        //测试案例线索二叉树
        ThreadBinaryTree threadBinaryTree = new ThreadBinaryTree();

        //创建二叉树
        threadBinaryTree.setRoot(root);
        //种序线索化二叉树
        //threadBinaryTree.threadedNodes();
        //前序线索化二叉树
        threadBinaryTree.threadPreNodes();

        HeroNode leftNode = heroNode5.getLeft();
        HeroNode rightNode = heroNode5.getRight();
        HeroNode rightNode2 = heroNode6.getRight();
        HeroNode leftNode2 = heroNode6.getLeft();
        System.out.println("10号节点的前驱节点为：" + leftNode);
        System.out.println("10号节点的后继节点为：" + rightNode);
        System.out.println("14号节点的前驱节点为：" + leftNode2);
        System.out.println("14号节点的后继节点为：" + rightNode2);

        //适用线索化二叉树中序遍历
        //System.out.println("线索化二叉树中序遍历：");
        //threadBinaryTree.threadedList();

    }
}

//创建节点
class HeroNode{
    private int id;
    private String name;
    private HeroNode left; //指针指向左节点
    private HeroNode right; //指针指向右节点

    //leftType = 0表示left指向左子树，为1表示指向前驱
    //rightType = 0表示指向右子树，为1表示指向后继
    private int leftType;
    private int rightType;

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

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }
}

//创建二叉树
class ThreadBinaryTree{
    private HeroNode root;  //指针指向根节点

    //为了实现线索化二叉树，需要创建一个指针指向当前节点的前驱
    //在实现递归线索化时，pre总是保留前一个结点
    private HeroNode pre;
    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //重载threadedNodes方法
    public void threadedNodes() {
        this.threadedNodes(root);
    }

    //遍历中序线索化二叉树
    public void threadedList() {
        //定义一个临时变量，存储当前遍历节点
        HeroNode node = root;
        while (node != null) {
            //找到 leftType = 1的节点
            //后面随着遍历而变化，因为当leftType = 1时，说明后序遍历是线性的,第一个为8
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            //打印当前这个节点
            System.out.println(node);
            //如果当前这个节点的右指针指向后继节点，则一直输出
            while (node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node);
            }
            //替换这个遍历节点
            node = node.getRight();
        }
    }

    //中序线索化二叉树node为当前线索化节点
    public void threadedNodes(HeroNode node) {
        //当前节点为空
        if (node == null) {
            return;
        }

        /**
         *  1、先线索化左子树
         *  2、线索化当前节点
         *  3、线索化右子树
         * */

        //线索化左子树
        threadedNodes(node.getLeft());
        //线索化当前节点

        //处理当前节点的前驱节点
        //以8节点为例
        //8.left = null 8.leftType = 1
        if (node.getLeft() == null) {
            //让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            //修改当前节点左指针的类型，指向前驱节点
            node.setLeftType(1);
        }

        //处理后继节点
        if (pre != null && pre.getRight() == null) {
            //让前驱节点的左指针指向当前节点
            pre.setRight(node);
            //修改前驱节点右指针的类型，指向后继节点
            pre.setRightType(1);
        }
        //处理每一个节点后，当前节点是下一个结点的前驱节点
        pre =  node;

        //线索化右子树
        threadedNodes(node.getRight());
    }
    //重载在序遍历方法
    public void threadPreNodes() {
        this.threadPreNodes(root);
    }

    //前序线索化二叉树ru
    public void threadPreNodes(HeroNode node) {
        //如当前节点为空直接返回
        if (node == null) {
            return;
        }
        //线索化当前节点
        //处理当前节点的前驱节点
        //设置当前节点的前驱节点为pre
        node.setLeft(pre);
        //设置节点当前指向前驱节点
        node.setLeftType(1);

        //处理当前节点的后继节点
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
        //线索化左子树
        threadPreNodes(node.getLeft());
        //线索化右子树
        threadPreNodes(node.getRight());

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


