package DailyQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 * 方法:原地修改
 * 若在1<=x<=n中,该数出现,对应的数组下标做一个标记,表示当前下标的数已经出现过,通过一系列方法进行判断,如果该下标没有被标记,
 * 说明该数不存在该数组中.(通过+数组长度来标记,大于该数组长度的数为标记过的
 *

 */
public class LeetCode448 {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
            int n = nums.length;
            for (int num : nums) {
                int x = (num - 1) % n;
                nums[x] += n;
            }
            List<Integer> ret = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                if (nums[i] <= n) {
                    ret.add(i + 1);
                }
            }
            return ret;
    }

    public static void main(String[] args) {
        int[] nums={4,3,2,7,8,2,3,1};
        List<Integer> disappearedNumbers = findDisappearedNumbers(nums);
    }
}
