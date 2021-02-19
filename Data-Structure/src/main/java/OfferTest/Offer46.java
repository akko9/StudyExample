package OfferTest;

/**
 *给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25
 * 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *示例 1:
  输入: 12258
  输出: 5
  解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 * 方法:动态规划
 */
public class Offer46 {
    public  static int translateNum(int num) {
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        int len=chars.length;
        if (len<2){
            return len;
        }
        int[] dp=new int[len+1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i <=len ; i++) {
            //只多一个数字 该数量=前一个的值
            dp[i]=dp[i-1];
            //由于 dp[0]=1; dp[1]=1; ,所以i-2相当于前一个数,i-1相当于本次数字
            int count=(chars[i-2]-'0')*10+(chars[i-1]-'0');
            if (count>9 &&count<26){
                dp[i]=dp[i-1]+dp[i-2];
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        int num=12258;
        int res = translateNum(num);
        System.out.println(res);
    }


}
