package BFSDemo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 此外，你可以假设该网格的四条边均被水包围。
 输入：grid = [
 ["1","1","1","1","0"],
 ["1","1","0","1","0"],
 ["1","1","0","0","0"],
 ["0","0","0","0","0"]
 ]
 输出：1
 *方法:BFS
 *
 */
public class LeetCode200 {
    public static int numIslands(char[][] grid) {
        int bfs = bfs(grid);
        System.out.println("bfs="+bfs);
        return bfs;
    }
    public static int  bfs(char[][] grid){
        int res=0;
        //数组高
        int row=grid.length;
        //数组长
        int column=grid[0].length;
        if (column == 0){
            return 0;
        }
        //bfs搭配队列
        Queue<int[]> queue=new LinkedList<int[]>();
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <column ; j++) {
                //确定指针
                if (grid[i][j]=='1'){
                    res++;
                    queue.add(new int[]{i,j});
                    grid[i][j]='0';
                }
                //开始取出queue的值
                while (queue.size()>0){
                    int[] poll = queue.poll();
                    System.out.println(Arrays.toString(poll));
                    int x=poll[0];
                    int y=poll[1];
                    //改变该值状态,避免出现死循环
                    //x+1不能等于 会越界
                    System.out.println(x+1);
                    if (x+1<row&&grid[x+1][y]=='1'){
                        grid[x+1][y]='0';
                        queue.add(new int[]{x+1,y});
                    }
                    if (x-1>=0&&grid[x-1][y]=='1'){
                        grid[x-1][y]='0';
                        queue.add(new int[]{x-1,y});
                    }
                    if (y+1<column&&grid[x][y+1]=='1'){
                        grid[x][y+1]='0';
                        queue.add(new int[]{x,y+1});
                    }
                    if (y-1>=0&&grid[x][y-1]=='1'){
                        grid[x][y-1]='0';
                        queue.add(new int[]{x,y-1});
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        numIslands(grid);
    }
}
