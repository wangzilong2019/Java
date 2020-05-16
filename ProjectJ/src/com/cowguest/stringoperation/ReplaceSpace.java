package com.cowguest.stringoperation;

public class ReplaceSpace {
    public static void main (String args[]) {
        Solution solution = new Solution();
        String newStr = solution.replaceSpace(new StringBuffer("123 34 00 "));
        System.out.println(newStr);
    }
}

class Solution {
    public String replaceSpace(StringBuffer str) {
        //先将它转换为String类型
        String newStr = str.toString();
        //创建一个新的StringBuffer
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < newStr.length(); i++) {
            //当字符不为' '添加到stringBuffer
            if (newStr.charAt(i) != ' ') {
                stringBuffer.append(newStr.charAt(i));
            } else {
                stringBuffer.append("%20");
            }
        }
        return stringBuffer.toString();
    }
}
