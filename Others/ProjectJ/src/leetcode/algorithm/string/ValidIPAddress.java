package leetcode.algorithm.string;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;

public class ValidIPAddress {
    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.validateIPv("192.169.1.1"));
    }
}

class Solution5 {

    /**
     *  验证IP地址是否有效
     *
     * */
    public String validIPAddress(String IP) {

        //使用自检查try-catch
        try {
            return (InetAddress.getByName(IP) instanceof Inet6Address) ? "IPv6" : "IPv4";
        } catch (Exception e) {

        }
        return "Neither";
    }

    /**
     *   d动态规划判断是否为正确的IP地址
     *     首先以分隔符来判断时IPV4还是IPV6
     *     然后以分隔符将此分割为每一小块，判断每一小块是否满足条件
     *       对于IPv4
     *         1、每一小块的长度1-4
     *         2、队与长度大于1的数字不能以0字符开头
     *         3、判断每个字符是否为数字字符
     *         4、每一块的大小
     *       对于IPv6
     *         1、判断每一小块的长度1-4
     *         2、判断每一小块的字符是否满足条件
     *
     * */

    /**
     *  队IPv4进行字符串匹配
     * */
    public String validateIPv4(String IP) {
        //首先将字符串分割分块
        //这里使用转义字符更安全
        String[] nums = IP.split("\\.");
        //判断是否分个为4块
        if (nums.length != 4) {
            return "Neither";
        }
        //满足分成4快的条件，则判断每一块是否满足tiaojian
        for (String str : nums) {
            //判断每一块的长度是否在1-4范围内
            if (str.length() == 0 || str.length() > 4) {
                return "Neither";
            }
            //当只有多个个数字时，判断是否0开头
            if (str.length() != 1 && str.charAt(0) == '0') {
                return "Neither";
            }
            //判断每个字符是否为数字
            for (char ch : str.toCharArray()) {
                if (!Character.isDigit(ch)) {
                    return "Neither";
                }
            }
            //判断每个数字大小是否在0-255范围内
            if (Integer.parseInt(str) < 0 || Integer.parseInt(str) > 255) {
                return "Neither";
            }
        }

        return "IPv4";
    }

    public String validateIPv6(String IP) {
        //将字符串分割
        String[] nums = IP.split(":");
        String pa = "0123456789abcdefABCDEF";
        //判断是否分割为8块
        if (nums.length != 8) {
            return "Neither";
        }

        //判断每一块分割是否有效
        for (String str : nums) {
            //判断每块数字长度
            if (str.length() == 0 || str.length() > 4) {
                return "Neither";
            }
            //判断每块中字符是否合法
            for (char ch : str.toCharArray()) {
                if (pa.indexOf(ch) < 0 || pa.indexOf(ch) >= pa.length()) {
                    return "Neither";
                }
            }
        }
        return "IPv6";
    }

    public String validateIPv(String IP) {
        //判断以.作为分隔符是否时3个.
        if (IP.chars().filter(ch -> ch == '.').count() == 3) {
            return validateIPv4(IP);
        }else if (IP.chars().filter(ch -> ch == ':').count() == 7) {
            return validateIPv6(IP);
        } else {
            return "Neither";
        }
    }
}