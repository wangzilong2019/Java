package leetcode.algorithm.string;

public class IntegerToRome12 {
}

class Solution6 {

    /**
     *  算法思想最大值为3999，所以可以拆分
     *   分别将千位、百位、十位、个位拆分然后计算
     * */
    public String intToRoman(int num) {
        String[] one = new String[] {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] two = new String[] {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] thr = new String[] {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] fou = new String[] {"", "M", "MM", "MMM"};

        return fou[num / 1000] + thr[num / 100 % 10] + two[num % 100 /10] + one[num % 10];
    }

    /**
     *   方法2动态规划思想
     *      将正数转换为罗马数字过程中，利用加法 因子区分解整数
     *      使得分解的整数尽可能少
     *      贪心算法思路：每一步都选择较大的罗马数字作为加法因子，最后得到的罗马数字总长度最小
     *
     * */
    public String intToRoman2(int num) {
        /**
         *  将罗马数字和阿拉伯数字向对应
         * */
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        //创建字符串构造器来生成罗马字符串
        StringBuilder sb = new StringBuilder();
        int index = 0;

        while (index < 13) {

            //采用贪心算法思想，用“=”尽量选用较大的“面值”，构造最短的字符串
            while (num >= nums[index]) {
                sb.append(romans[index]);

                num = num - nums[index];
            }
            //当当前币值太大而所需要的有很小index++找到满足的小币值
            index++;
        }

        return sb.toString();
    }
}