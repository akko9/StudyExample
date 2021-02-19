package DailyQuestion;

/**
 * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
 *
 * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
 *
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
 *
 * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 *
 * 示例 1:
 *
 * 输入:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 1, c = 4
 * 输出:
 * [[1,2,3,4]]
 * 解释:
 * 行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
 *
 *
 */
public class LeetCode566 {
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length==0){
            return nums;
        }
        if (nums.length==r && nums[0].length==c ){
            return nums;
        }
        int[] temps=new int[nums.length*nums[0].length];
        int index1=0;
        //转换
        for (int[] num : nums) {
            for (int i : num) {
                temps[index1++] = i;
            }
        }
        //判断是否符合矩阵规矩
        if (r*c!=temps.length){
            return nums;
        }
        int[][] res=new int[r][c];
        int index2=0;
        //构造
        for (int i = 0; i <r ; i++) {
            for (int j = 0; j <c ; j++) {
                    res[i][j]=temps[index2++];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums={{1,2}, {3,4}};
        int[][] ints = matrixReshape(nums, 2, 4);
        for (int[] num : ints) {
            for (int i : num) {
                System.out.print(" "+i);
            }
            System.out.println();
        }
    }
}
