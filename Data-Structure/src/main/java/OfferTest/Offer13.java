package OfferTest;

import java.util.Arrays;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 *
 * 来源：力扣（LeetCode）
 * 方法:
 */
public class Offer13 {
    public static int movingCount(int m, int n, int k) {
        boolean[][] map=new boolean[m][n];
        //dfs递归
        /*
        map  机器人行走路径
        m 地图列
        n 地图行
        x 机器人行走列数
        y 机器人行走行数
        k 限制条件
         */
        return dfs(map, m, n, 0, 0, k);
    }
    public static int dfs(boolean[][] map,int m,int n,int x,int y,int k){
        if (x>=m || y>=n || map[x][y] ||getSum(x)+getSum(y)>k){
            return 0;
        }
        //给定标记 ,已走过
        map[x][y]=true;
        //dfs(map,m,n,x+1,y,k)递归到底 返回向下走的步数
        //dfs(map,m,n,x,y+1,k)递归到底 返回向右走的步数
        //因为[0,0]->[m-1,n-1] 所以不需要考虑左边和上边
        return 1+dfs(map,m,n,x+1,y,k)+dfs(map,m,n,x,y+1,k);

    }
    //计算位总和
    public static int getSum(int num) {
        {
            int sum = num % 10;
            int tmp = num / 10;
            while (tmp > 0) {
                sum += tmp % 10;
                tmp /= 10;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        int res = movingCount(2, 3, 1);
        System.out.println(res);
    }
}
