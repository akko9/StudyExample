package DivideAndConquerAlgorithm;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *方法:分治
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class LeetCode53 {
    public static  int maxSubArray(int[] nums) {
       return   merge(nums,0,nums.length-1);
    }
    public static int merge(int[] nums,int left,int right){
        //base case
        if (left==right){
            return nums[left];
        }
        int mid=left+(right-left)/2;
        //左
        int leftMax = merge(nums, left, mid);
        //右
        int rightMax =merge(nums, mid + 1, right);
        //中间
        int mediumMax=getMax(nums, left, right);
        //三个比大小
        return Math.max(mediumMax,Math.max(leftMax,rightMax));
    }
    //如何获得中间最大的值
    //中间向两边计算,左边最大+加上右边最大
    public static int getMax(int[] nums, int left, int right) {
        int mid=left+(right-left)/2;

        int leftCount=nums[mid];
        int leftMax=leftCount;
        for (int i =mid-1; i >=left ; i--) {
            leftCount=leftCount+nums[i];
            leftMax = Math.max(leftMax,leftCount);
        }

        int rightCount=nums[mid+1];
        int rightMax=rightCount;
        for (int i = mid+2; i <=right ; i++) {
            rightCount=rightCount+nums[i];
            rightMax = Math.max(rightMax, rightCount);
        }
        return leftMax+rightMax;

    }

    public static void main(String[] args) {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        int i = maxSubArray(nums);
        System.out.println(i);
    }
}
