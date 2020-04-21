package search;

public class InsertValueSearch {
    public static void main (String args[]) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int resIndex = insertValueSearch(arr, 0, arr.length - 1, 3);
        System.out.println("查找结果：" + resIndex);

    }

    //注意：findValue > arr[arr.length - 1] || findValue < arr[0]
    //此判断条件必须有，否则我们得到的mid可能越界
    public static int insertValueSearch (int[] arr, int left, int right, int findValue) {
        while (left <= right) {
            //此步起到优化作用而且必须有
            if (findValue > arr[arr.length - 1] || findValue < arr[0]) {
                break;
            }
            int mid = left + (right - left) * (findValue - arr[left]) / (arr[right] - arr[left]);
            if (findValue == arr[mid]) {
                return mid;
            } else if (findValue < arr[mid]) {
                return insertValueSearch(arr, left, mid - 1, findValue);
            } else {
                return insertValueSearch(arr, mid + 1, right, findValue);
            }
        }
        //若此元素不在其中，查找不到
        return -1;
    }
}
