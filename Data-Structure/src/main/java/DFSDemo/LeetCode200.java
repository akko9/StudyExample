package DFSDemo;
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
 *方法:DFS
 *
 */
public class LeetCode200 {
    public static int numIslands(char[][] grid) {
        int res=0;
        //找到岛屿
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j <grid[0].length ; j++) {
                if (grid[i][j]=='1'){
                    res++;
                    //开始扩散
                    dfs(grid,i,j,grid.length,grid[0].length);
                }
            }
        }
        return res;
    }

    private static void dfs(char[][] grid,int x,int y,int row,int col) {
        row=grid.length;
        col=grid[0].length;
        //判断
        if (x>=row ||x<0 || y<0|| y>=col ||grid[x][y]=='0'){
            return ;
        }
        grid[x][y]='0';
        dfs(grid,x+1,y,row,col);
        dfs(grid,x-1,y,row,col);
        dfs(grid,x,y+1,row,col);
        dfs(grid,x,y-1,row,col);

    }
    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        int res = numIslands(grid);
        System.out.println("res="+res);
    }
}
