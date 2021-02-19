package OfferTest;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 方法:动态规划
 *
 */
public class Offer10 {
    public static int fib(int n) {
        if (n==0){
            return 0;
        }
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for (int i = 2; i <=n ; i++) {
            dp[i]=dp[i-1]+dp[i-2];
            //每次循环结果取模,防止超出int范围
            dp[i]%=1000000007;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int fib = fib(48);
        System.out.println(fib);
    }
}
