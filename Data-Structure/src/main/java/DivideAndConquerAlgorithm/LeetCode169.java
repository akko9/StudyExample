package DivideAndConquerAlgorithm;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 来源：力扣（LeetCode）
 * 方法:分治
 *
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
0
 */
public class LeetCode169 {
    public static int majorityElement(int[] nums) {
      return count(nums, 0, nums.length-1);
    }
    //定义左边界和右边界
    public  static int count(int[] nums,int left,int right){
        //base case 单递归到left==right时,到底了，返回该值
        if (left==right){
            return nums[left];
        }
        //取中间这
        int mid=left+(right-left)/2;
        //左递归
        int leftMajority = count(nums, left, mid);
        //有递归
        int rightMajority = count(nums, mid + 1, right);
        return choose(nums, left, right, leftMajority, rightMajority);
    }

    public static int choose(int[] nums, int left, int right, int leftMajority, int rightMajority) {
        //同一层 如果返回的值相等,选任意一个
        if (leftMajority==rightMajority){
            return leftMajority;
        }
        //当不相等时,遍历该区间,去这两个值出现次数多的数
        int leftCount=0;
        int rightCount=0;
        for (int i = left; i <=right ; i++) {
            if (nums[i]==leftMajority){
                leftCount++;
            }else if (nums[i]==rightMajority){
                rightCount++;
            }
        }
        if (leftCount>rightCount){
            return leftMajority;
        }else{
            return rightMajority;
        }
    }

    public static void main(String[] args) {
        int[] nums={2,2,1,1,1,2,2};
        int res = majorityElement(nums);
        System.out.println(res);
    }
}
