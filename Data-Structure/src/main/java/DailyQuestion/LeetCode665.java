package DailyQuestion;

/**
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 * 示例 1:
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 *
 * 方法:多重判断
 *
 */
public class LeetCode665 {
    public boolean checkPossibility(int[] nums) {
        int count=0;
        for (int i = 1; i <nums.length ; i++) {
            if (nums[i-1]>nums[i]){
                count+=1;
                //1.当i=1时,修改前面一位的
                //2.当nums[i]>=nums[i-2],修改前面一位
                //3.当nums[i]<=nums[i-2],修改该位
                if (i==1 || nums[i]>=nums[i-2]){
                    nums[i-1] = nums[i];
                }else{
                    nums[i]=nums[i-1];
                }
            }
        }
        return count <= 1;
    }
}
