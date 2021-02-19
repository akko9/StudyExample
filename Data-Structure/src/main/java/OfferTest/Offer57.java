package OfferTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * 来源：力扣（LeetCode）
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * 方法:滑动窗口
 */
public class Offer57 {
    public static int[][] findContinuousSequence(int target) {
        int left=1;//左指针 从1开始,不然0会加入数组
        int right=1; //右指针
        int sum=0; //每次相加的和
        List<int[]> list=new ArrayList<int[]>();
        //当left大于target/2 ,因为左指针下次移动sum必然大于target
        while (left<=target/2){
            //当sum小于target 右指针可以继续移动
            if (sum<target){
                //先将当前的数进行处理,再移动指针
                sum+=right;
                right++;
            }else if (sum>target){
                //先将当前的数进行处理,再移动指针
                sum-=left;
                left++;
            }else{
                //定义数组
                int[] res=new int[right-left];
                //从left到right窗口的值添加到数组内
                for (int i =left; i <right; i++) {
                    //i-left 相当于从index=0开始
                    res[i-left]=i;
                }
                //将结果加入list
                list.add(res);
                //继续移动左指针,寻找左指针后面是否还有满足条件的值
                //先将当前的数进行处理,再移动指针
                sum-=left;
                left++;
            }
        }
        //list转换数组
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] continuousSequence = findContinuousSequence(9);
        for (int i = 0; i <continuousSequence.length ; i++) {
            System.out.println(Arrays.toString(continuousSequence[i]));
        }
    }
}
