package OfferTest;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 *
 * 方法:暴力
 */
public class Offer53 {
    public int search(int[] nums, int target) {
        int count =0;
        for (int i = 0; i <nums.length ; i++) {
            if (target==nums[i]){
                count++;
            }
        }
        return count;
    }
}
