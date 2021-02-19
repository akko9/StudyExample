package OfferTest;

import org.omg.CORBA.MARSHAL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * 方法:暴力
 */
public class Offer59Two {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length==0 || k==0){
            return new int[0];
        }
        int left=0;
        int right=k-1;
        int count=0;
        int max=Integer.MIN_VALUE;
        int[] res=new int[nums.length-k+1];
        for (int i = left; i <=right ; i++) {
            max=Math.max(max,nums[i]);
        }
        res[count++]=max;
        while (right<nums.length-1){
            right++;
            max=Math.max(nums[right],max);
            left++;
            res[count++]=max;
        }
        return res;
    }

    public static int[] getIntsOne(int[] nums, int k) {
        if (nums.length==0 || k==0){
            return new int[0];
        }
        int left=0;
        int right=k-1;
        int count=0;
        int[] res=new int[nums.length-k+1];
        while (right<nums.length){
            int max=Integer.MIN_VALUE;
            for (int i = left; i <=right ; i++) {
                max=Math.max(max,nums[i]);
            }

            res[count++]=max;
            right++;
            left++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums={1,3,-1,-3,5,3,6,7};
        int[] ints = maxSlidingWindow(nums, 3);
    }
}
