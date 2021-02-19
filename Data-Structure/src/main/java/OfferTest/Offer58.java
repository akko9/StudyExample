package OfferTest;
/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * 示例 1：
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 *
 * 方法:双倍字符串
 */
public class Offer58 {
    public static String reverseLeftWords(String s, int n) {
        if (s==null || "".equals(s)){
            return "";
        }
        String ss=s+s;
        int len=s.length();
        String res = ss.substring(n, len + n);
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        String s="abcdefg";
       reverseLeftWords(s, 2);

    }
}
