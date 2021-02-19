package DailyQuestion;

/**
 * 2021.1.28
 * 给你一个整数数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
 * 数组 中心索引 是数组的一个索引，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果数组不存在中心索引，返回 -1 。如果数组有多个中心索引，应该返回最靠近左边的那一个。
 * 注意：中心索引可能出现在数组的两端。
 * 来源：力扣（LeetCode）
 * 方法:指针
 *
 * 输入：nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
 * 同时, 3 也是第一个符合要求的中心索引

 */
public class LeetCode724 {
    public  static int pivotIndex(int[] nums) {
        if (nums.length==0){
            return -1;
        }
        int total=0;
        for (int j = 0; j <nums.length ; j++) {
            total=total+nums[j];
        }
        for (int i = 0; i <nums.length ; i++) {
            int ls=0;
            int rs=0;
            for (int j = 0; j <i ; j++) {
               ls=ls+nums[j];
            }
            rs=total-ls-nums[i];
            if (ls==rs){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums={2,1,-1};
        int i = pivotIndex(nums);
        System.out.println(i);
    }
}
