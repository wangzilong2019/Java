//package com.guigu.huffmancode;
//
//import java.util.*;
//
//public class HuffmanCode {
//    public static void main (String args[]) {
//        String content = "i like like like java do you like a java";
//        byte[] contentBytes = content.getBytes();
//
//        List<Node> list = getNodes(contentBytes);
//
//        //创建哈夫曼树
//        Node huffmanTreeRoot = createHuffmanTree(list);
//
//        //前序遍历
//        huffmanTreeRoot.preOrder();
//
//        //生成哈夫曼编码
//        Map<Byte, String> huffmanCodes =  getCodes(huffmanTreeRoot);
//        System.out.println("生成的哈夫曼编码为：" + huffmanCodes);
//
//        //测试
//        byte[] huffmanBytes = huffmanZip(contentBytes);
//        System.out.println("huffmanBytes:" + Arrays.toString(huffmanBytes));
//
//    }
//
//    /**
//     *  完成数据的解压
//     *    1、先将huffmanCodeBytes转换成对应的二进制字符串（注意是补码）
//     *    2、将哈夫曼编码对应的二进制字符出啊转化成字符串原始数据
//     *    3、标志位最高位若是true，则需要补高位，false则不需要
//     *    4、return 返回的是 b 的二进制补码对应的字符串
//     * */
//
//    /**
//     *  编写一个方法，对压缩的数据进行解码
//     *  huffmanCodes  哈夫曼编码表
//     *  huffmanBytes 哈夫曼编码得到的字节数组
//     *  return 原来的字符串对应的数组
//     *
//     * */
//
//    private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {
//        //先得到huffmanBytes对应的二进制字符串
//        StringBuilder stringBuilder = new StringBuilder();
//        //将byte数组转化成对应的二进制字符串
//        for (int i = 0; i < huffmanBytes.length; i++) {
//            byte b = huffmanBytes[i];
//            //判断是不是最后一个字节
//            boolean flag = (i == huffmanBytes.length - 1);
//            stringBuilder.append(byteToBitString(!flag, b));
//        }
//    }
//
//    /**
//     *    3、标志位最高位若是true，则需要补高位，false则不需要，若是最后一个字节则也不需要补高位
//     *    4、return 返回的是 b 的二进制补码对应的字符串
//     * */
//
//    private static String byteToBitString(boolean flag, byte b) {
//        //使用变量temp保存b
//        int temp = b;
//        //若正数存在最高补位
//        if (flag) {
//            temp |= 256;
//        }
//        //返回的是temo对应的二进制补码
//        String str = Integer.toBinaryString(temp);
//        if (flag) {
//            return str.substring(str.length() - 8);
//        } else {
//            return str;
//        }
//    }
//
//
//    /**
//     *  边写一个方法，将方法封装起来
//     *     1、bytes 原始的字符串对应的字节数组
//     *     2、return 经哈夫曼处理后的字节数组
//     *
//     * */
//
//    private static byte[] huffmanZip(byte[] bytes) {
//        //将原始的字节数组创建成节点
//        List<Node> list = getNodes(bytes);
//        //根据节点创建哈夫曼树
//        Node huffmanRoot = createHuffmanTree(list);
//        //根据哈夫曼树创建对应的哈夫曼编码
//        Map<Byte, String> huffmanCodes = getCodes(huffmanRoot);
//        //根据哈夫曼编码，压缩得到压缩后的哈夫曼编码字节数组
//        byte[] huffmanCodeByte = zip(bytes, huffmanCodes);
//        return huffmanCodeByte;
//    }
//
//    //编写一个方法，将字符串对应的byte[]数组通过生成的哈夫曼编码表，返回一个哈夫曼编码压缩后的byte[]
//    /**
//     * bytes  原始的字符串对应的byte[]
//     * huffmanCodes 生成的哈夫曼编码map
//     * 说明：哈夫曼编码若要转化成十进制则哈夫曼编码对应的为补码，要转化成原码
//     *
//     * */
//
//    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
//        //1、利用huffmanCodes将bytes转成哈夫曼对应的字符串
//        StringBuilder stringBuilder = new StringBuilder();
//        for (byte x : bytes) {
//            stringBuilder.append(huffmanCodes.get(x));
//        }
//
//        //统计返回huffmanCodes对应的长度
//        int len;
//        if (stringBuilder.length() % 8 == 0) {
//            len = stringBuilder.length() / 8;
//        } else {
//            len = stringBuilder.length() / 8 + 1;
//        }
//
//        //创建存储后的huffmanBytes数组
//        byte[] huffmanBytes = new byte[len];
//        int index = 0;  //记录是第几个byte
//        for (int i = 0; i < stringBuilder.length(); i += 8) {  //因为是每8位对应一个byte所以步长为8
//            String strByte = null;
//            if (i + 8 > stringBuilder.length()) {
//                strByte = stringBuilder.substring(i);
//            } else {
//                strByte =  stringBuilder.substring(i, i + 8);
//            }
//            //将strByte转换成一个byte，存放到huffmanCodes中
//            huffmanBytes[index] = (byte) Integer.parseInt(strByte, 2);
//            index++;
//        }
//        return huffmanBytes;
//    }
//
//    /**
//     *  思路：
//     *   1、将哈夫曼编码存放在Map<Byte,String>行式中
//     *      字符的ASCII码对应的豪夫曼编码
//     *   2、在生成的哈夫曼编码中，需要去拼接路径，定义一个StringBuilder来存储某个非叶子节点的路径
//     *
//     * */
//    //来存放字符对应的哈夫曼编码
//    static Map<Byte, String> huffmanCode = new HashMap<Byte, String>();
//    //定义一个字符串生成器来生成非叶子节点的路径
//    static StringBuilder stringBuilder = new StringBuilder();
//
//    /**
//     *  生成哈夫曼编码表
//     *  功能：将传入node节点的所有非叶子节点的哈夫曼编码得到，并存放到huffmanCode集合中
//     *   1、node代表传入的节点
//     *   2、code代表路径：左节点0，右节点1
//     *   stringBuilder用来拼接路径
//     * */
//
//    //为了调用方便实现方法的重载
//    private static Map<Byte, String> getCodes(Node huffmanRoot) {
//        if (huffmanRoot == null) {
//            return null;
//        } else {
//            getCodes(huffmanRoot, "", stringBuilder);
//        }
//        return huffmanCode;
//    }
//
//    private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
//        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
//        //将code加入到StringBuilder2
//        stringBuilder2.append(code);
//        if (node != null) { //当node == null不处理
//            //判断当前节点是叶子节点还是非叶子节点
//            if (node.data == null) { //非叶子节点
//                //向左递归
//                getCodes(node.left, "0", stringBuilder2);
//                //向有递归
//                getCodes(node.right, "1", stringBuilder2);
//            } else {
//                //此时为叶子节点
//                huffmanCode.put(node.data, stringBuilder2.toString());
//            }
//        }
//    }
//
//    //前序遍历方法
//    private static void preOrder(Node root) {
//        if (root != null) {
//            root.preOrder();
//        } else {
//            System.out.println("该二叉树为空");
//        }
//    }
//
//    private static List<Node> getNodes(byte[] bytes) {
//        //1、创建一个List
//        List<Node> list = new ArrayList<Node>();
//
//        //2、创建一个map同统计每字符出现的次数
//        Map<Byte, Integer> counts = new HashMap<>();
//
//        //统计每个字符出现的次数
//        for (byte x : bytes) {
//            Integer count = counts.get(x);
//            //当此字符第一次出现时
//            if (count == null) {
//                counts.put(x, 1);
//            } else {
//                counts.put(x, count + 1);
//            }
//        }
//
//        //把每一个键值对转化成Node对象且加入list集合中
//        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
//            list.add(new Node( entry.getKey(), entry.getValue()));
//        }
//        return list;
//    }
//
//    //通过list创建哈夫曼树
//    private static Node createHuffmanTree(List<Node> list) {
//        //构造哈夫曼树
//        while (list.size() > 1) {
//            //从小到排序
//            Collections.sort(list);
//
//            //取出最小权值的俩个节点
//            Node leftNode = list.get(0);
//            Node rightNode = list.get(1);
//
//            //以俩个节点构造二叉树
//            Node parent = new Node(null, leftNode.weight + rightNode.weight);
//            parent.left = leftNode;
//            parent.right = rightNode;
//
//            //将根节点加入，俩个叶子节点删除
//            list.add(parent);
//            list.remove(leftNode);
//            list.remove(rightNode);
//        }
//
//        //返回根节点
//        return list.get(0);
//    }
//}
//
//class Node implements Comparable<Node> {
//    Byte data; //存放节点的字符
//    int weight;  //存放字符出现次数
//    Node left;
//    Node right;
//
//    //节点构造器
//    public Node(Byte data, int weight) {
//        this.data = data;
//        this.weight = weight;
//    }
//
//    //前序遍历
//    public void preOrder() {
//        System.out.println(this);
//        if (this.left != null) {
//            this.left.preOrder();
//        }
//        if (this.right != null) {
//            this.right.preOrder();
//        }
//    }
//
//    //方法重载
//    public String toString() {
//        return "Node [ data " + data + " weight " + weight + "]";
//    }
//
//    public int compareTo(Node o) {
//        //从小到大排序
//        return this.weight - o.weight;
//    }
//}
