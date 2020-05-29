package com.cowguest.stringoperation;

public class DeleteCommonString {
    public static void main (String args[]) {
        System.out.println((new Solution1()).deleteCommonString("12345  r", "45 "));
    }
}

class Solution1{
    public String deleteCommonString(String str, String fStr) {
        //创建一个S听Bu愤愤然类用于保存新字符串
        StringBuffer sb = new StringBuffer();
        //遍历字符串
        for (int i = 0; i < str.length(); i++) {
            //当没有在第二个字符串中出现时则添加到新字符串中
            if (!findChar(str.charAt(i), fStr)) {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    //查找字符是否在字符串中出现
    public boolean findChar(char ch, String str) {
        for (int i = 0; i < str.length(); i++) {
            if (ch == str.charAt(i)) {
                return true;
            }
        }
        return false;
    }
}