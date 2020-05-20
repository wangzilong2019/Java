package com.cowguest.string;

public class MatchReg {
    public static void main (String args[]) {
        String reg = "[abc]4";  //用[]括起来的若干个字符表示一个元字符，该元字符可代表括号中的任意一个字符
        String reg2 = "[^abc]4";   //用[^]括起来的若干个字符表示一个元字符，该元字符可代表括号之外的任意一个字符
        String str = "a4";
        String str2 = "aa";
        System.out.println(str.matches(reg));
        System.out.println(str.matches(str2));
    }
}
