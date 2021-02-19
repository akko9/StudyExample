package DoublePointer;

import java.util.Arrays;

/**
 * 难度:中等
 * 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 * 来源:leetcode
 * 方法:对撞双指针(先排序)(贪心)

 输入：people = [3,2,2,1], limit = 3
 输出：3
 解释：3 艘船分别载 (1, 2), (2) 和 (3)
 */
public class LeetCode881 {
    //int[] people 每个数值为每个人的体重
    //limit 船承载最大值
    public static int numRescueBoats(int[] people, int limit) {
        //临界条件
        if (people==null || limit==0){
            return 0;
        }
        int res=0;
        int left=0;
        int right=people.length-1;
        //排序才能用对撞双指针
        Arrays.sort(people);

        while (left<=right){
            if (left==right){
                //最后left与right重合,只能一人乘船
                return res+1;
            }
            if (people[left]+people[right]<=limit){
                //如果两人体重没超则,则指针都移动
                left++;
            }
            //优先体重大的先走
            right--;
            //走一人,加一
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] people={3,3,2,1};
        int limit=3;
        int res = numRescueBoats(people, limit);
        System.out.println(res);
    }
}
