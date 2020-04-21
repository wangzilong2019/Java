package search;

public class SeqSearch {
    public static void main (String args[]) {
        int[] arr = new int[]{9, -8, 2, 3, 2, 8, 0};
        int[] indexArr;
        indexArr = seqSearch(arr, 2);
        //当索引值为-1时代表查无此元素
        for (int i = 0; i < indexArr.length; i++) {
            if (indexArr[i] == -1) {
                System.out.println("查无此元素");
            } else {
                System.out.println("查找到元素索引为：" + indexArr[i]);
            }
        }
    }

    /**
     * 顺序查找
     * 将带查找索引放入一个数组中，-1代表没有查找到
     * */
    public static int[] seqSearch(int[] arr, int value) {
        int[] tempIndex = new int[arr.length];  //闯进啊一个数组来存放查找索引
        int index = 0;
        //遍历元素
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                tempIndex[index++] = i;
            }
        }
        //当没有找到此元素时索引为-1
        if (tempIndex.length == 0) {
            tempIndex[index] = -1;
        }
        return tempIndex;
    }
}
