package DynamicProgramming;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 * 来源：力扣（LeetCode）
 * 方法:动态规划

 */
public class LeetCode62 {
    public static int uniquePaths(int m, int n) {
        int res=0;
        int[][] dp=new int[m][n];
        //竖向行走一条路线
        for (int i = 0; i< dp.length  ; i++) {
            dp[i][0]=1;
        }
        //横向行走一条路线
        for (int i = 0; i <dp[0].length; i++) {
            dp[0][i]=1;
        }
        for (int i = 1; i <dp.length ; i++) {
            for (int j = 1; j <dp[0].length ; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
                System.out.println("dp["+i+"]["+j+"]:"+dp[i][j]);
            }
        }
        //例：m=3  0,1,2
        res=dp[m-1][n-1];
        return res;
    }

    public static void main(String[] args) {
        int res = uniquePaths(1, 2);
        System.out.println(res);
    }
}
