package DailyQuestion;

/**
 *未完成
 * 你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
 * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
 * 请你返回从左上角走到右下角的最小 体力消耗值 。
 * 来源：力扣（LeetCode）
 * 方法:
 *
 * 输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
 * 输出：2
 * 解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
 * 这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
 */
public class LeetCode1631 {
    public static int minimumEffortPath(int[][] heights) {
        int res=0;
        int way = getWay(heights, 0, 0, 0);
        //int abs = Math.abs(heights[0][1] - heights[0][0]);
        System.out.println(way);
        return res;
    }
    public  static int getWay(int[][] nums,int x,int y,int strength){
        int width=nums[0].length-1;
        int height=nums.length-1;
        if (x==width&&y==height){
            return strength;
        }
        System.out.println("x:"+x+"y:"+y);
        if (1<=x&&x<=width&&0<=y&&y<=height&&Math.abs(nums[x-1][y]-nums[x][y])<2){
            if (Math.abs(nums[x-1][y]-nums[x][y])>=strength){
                strength=Math.abs(nums[x-1][y]-nums[x][y]);
            }
            getWay(nums,x-1,y,strength);
        }else if (0<=x&&x<=width-1&&0<=y&&y<=height&&Math.abs(nums[x+1][y]-nums[x][y])<2){
            if (Math.abs(nums[x+1][y]-nums[x][y])>=strength){
                strength=Math.abs(nums[x+1][y]-nums[x][y]);
            }
            getWay(nums,x+1,y,strength);
        }else if (0<=x&&x<=width&&1<=y&&y<=height&&Math.abs(nums[x][y-1]-nums[x][y])<2){
            if (Math.abs(nums[x][y-1]-nums[x][y])>=strength){
                strength=Math.abs(nums[x][y-1]-nums[x][y]);
            }
            getWay(nums,x,y-1,strength);
        }else if (0<=x&&x<=width&&0<=y&&y<=height-1&&Math.abs(nums[x][y+1]-nums[x][y])<2){
            if (Math.abs(nums[x][y+1]-nums[x][y])>=strength){
                strength=Math.abs(nums[x][y+1]-nums[x][y]);
            }
            getWay(nums,x,y+1,strength);
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] heights={{1,2,2},{3,8,2},{5,3,5}};
        minimumEffortPath(heights);
    }
}
