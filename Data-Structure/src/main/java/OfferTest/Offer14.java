package OfferTest;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 *
 * 方法:动态规划

 */
public class Offer14 {
    public  static int cuttingRope(int n) {
        if (n==0){
            return 0;
        }
        // 特殊情况
        if(n == 2 || n==1 ){
            return 1;
        }
        int[] dp=new int[n+1];
        dp[2]=0;
        int max=0;
        for (int i = 2; i <=n ; i++) {
            for (int j =1 ; j <i ; j++) {
                //里面的dp[i]为了保持dp[i]最大
                //j*(i-j)不在剪断
                //j*dp[i-j]继续剪断
                dp[i]=Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]));
                System.out.println("dp["+i+"]:"+dp[i]);
            }

        }
        return dp[n];
    }

    public static void main(String[] args) {
        int res = cuttingRope(10);
        System.out.println(res);
    }
}
