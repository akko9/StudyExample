package OfferTest;

import java.util.Arrays;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 *
 */
public class Offer58Two {
    public static String reverseWords(String s) {
        //去除字符串的头尾空格
        s=s.trim();
        String[] s1 = s.split(" ");
        int len=s1.length-1;
        int index=0;
        String[] res=new String[s1.length];
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = len; i>=0 ; i--) {
            if(s1[i].equals("")) continue; // 遇到空单词则跳过
            stringBuilder.append(s1[i] + " "); // 将单词拼接至 StringBuilder
        }
        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        String s="the sky is blue";
        String s1 = reverseWords(s);
        System.out.println(s1);
    }
}
