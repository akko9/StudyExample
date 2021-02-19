package Backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 *给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class LeetCode78 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if (nums.length==0){
            return res;
        }
        for (int i = 1; i <=nums.length ; i++) {
            Dfs(nums,res,i,0,new ArrayDeque<Integer>());
        }
        return  res;
    }
    public static void Dfs(int[] nums, List<List<Integer>> res, int height, int target,Queue<Integer> queue){
        //base case
        if (target==height){
            res.add(new ArrayList<Integer>(queue));
            return;
        }
        for (int i = target; i <nums.length ; i++) {
            queue.add(nums[i]);
            Dfs(nums,res,height,i+1,queue);
            queue.poll();
        }

    }

    public static void main(String[] args) {
       int[] nums = {1,2,3};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets);
    }
}
