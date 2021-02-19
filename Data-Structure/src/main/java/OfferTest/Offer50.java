package OfferTest;

import java.util.HashMap;
import java.util.Map;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *
 * 方法:hashMap(可以用boolean类型来标记)
 */
public class Offer50 {
    public char firstUniqChar(String s) {
        Map<Character,Integer> map=new HashMap<Character, Integer>();
        char[] chars = s.toCharArray();
        for (char ss:chars) {
            if (!map.containsKey(ss)){
                map.put(ss,1);
            }else{
                map.put(ss,map.get(ss)+1);
            }
        }
        for (Character ss:chars) {
            if (map.get(ss)==1){
                return ss;
            }
        }
        return ' ';
    }
}
