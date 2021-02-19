package OfferTest;

import java.util.HashMap;
import java.util.Map;

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]

 */
public class Offer56 {
    public int[] singleNumbers(int[] nums) {
        Map<Integer,Integer> map=new HashMap<Integer, Integer>();
        for (Integer num:nums) {
            if (!map.containsKey(num)){
                map.put(num,1);
            }else{
                map.put(num,map.get(num)+1);
            }
        }
        int[] res=new int[2];
        int index=0;
        for (Integer num:map.keySet()) {
            if (map.get(num)==1){
                res[index++]=num;
            }
        }
        return res;
    }
}
