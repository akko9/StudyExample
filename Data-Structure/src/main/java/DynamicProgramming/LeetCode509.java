package DynamicProgramming;

/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给你 n ，请计算 F(n) 。
 *
 * 来源：力扣（LeetCode）
 * 方法:动态规划

 */
public class LeetCode509 {
    public static int fib(int N) {
        //边界值
        if (N==0){
            return 0;
        }
        if (N==1){
            return 1;
        }
        //dp数组
        int[] dp=new int[N+1];
        //F(n) = F(n - 1) + F(n - 2)
        if (N>1){
            dp[0]=0;
            dp[1]=1;
            for (int i = 2; i <=N ; i++) {
                dp[i]=dp[i-1]+dp[i-2];
            }
        }
        return dp[N];
    }

    public static void main(String[] args) {
        int fib = fib(5);
        System.out.println(fib);
    }
}
