package OfferTest;

import java.util.HashMap;
import java.util.Map;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

 */
public class Offer48 {
    public  static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Map<Character,Integer> map=new HashMap<Character, Integer>();
        int left=-1;
        int max=0;
        for (int i = 0; i <chars.length ; i++) {
            if (map.containsKey(chars[i])){
                // map.get(chars[i]) 找到当前值在前面的索引位置
                left = Math.max(left, map.get(chars[i]));
            }
            //更新当前值的索引位置
            map.put(chars[i],i);
            //i-left为滑动窗口的大小,例:index=2 ,窗口大小2-（-1）=3;
            max=Math.max(max,i-left);
        }
        return max;
    }

    public static void main(String[] args) {
        int res = lengthOfLongestSubstring("pwwkew");
        System.out.println(res);
    }

}

//Map<Character, Integer> dic = new HashMap<Character, Integer>();
//        int i = -1, res = 0;
//        for(int j = 0; j < s.length(); j++) {
//            if(dic.containsKey(s.charAt(j)))
//                i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
//            dic.put(s.charAt(j), j); // 哈希表记录
//            res = Math.max(res, j - i); // 更新结果
//        }
//        return res;