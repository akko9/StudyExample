package OfferTest;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 * 方法:双指针(左右)(快慢)
*/
public class Offer21 {
    public static int[] exchange(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while (left<right){
            //不能是while,会数组越界
            if (nums[left]%2!=0 ){
                left++;
            }
            if (nums[right]%2==0){
                right--;
            }
            if (left<right){
                int temp=nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
            }
        }
        return nums;
    }


    public static void main(String[] args) {
        int[] nums={2,4,6};
        int[] exchange = exchange(nums);
        System.out.println(Arrays.toString(exchange));
    }
}
