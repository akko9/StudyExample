package Sort;

import java.util.Arrays;

/**
 *从中数组中选取最的最大或最小的数放入最后。依次循环
 * 时间复杂度
 * 最优:已经排列好了的O(n) 需要一个标识符flag
 * 最差:倒叙变正序O( n^2 )
 * 平均的时间复杂度为：O( n^2 )；
 * 空间复杂度
 * 最优的空间复杂度就是开始元素顺序已经排好了，则空间复杂度为：0；
 * 最差的空间复杂度就是开始元素逆序排序了，则空间复杂度为：O(n)；
 * 稳定性:稳定
 */
public class BubbleSort {
    /*
    从小到大排序
    一次循环    两次循环   三次循环     稳定性
    4,3,2,1    2,3,1,4   1,2,3,4    4,2,2,1
    3,4,2,1    2,1,3,4              2,4,2,1
    3,2,4,1                         2,2,4,1
    3,2,1,4
     */
    //未添加标识符
    public void Sort(int[] nums){
        //添加标识符,减少循环  如果flag=false; 数组有交换
        boolean flag=false;
        //验证标志符的正确性
        int count=0;
        for (int j = 0; j < nums.length-1; j++) {
            for (int i = 0; i <nums.length-1 ; i++) {
                if (nums[i]>nums[i+1]){
                    int temp=nums[i+1];
                    nums[i+1]=nums[i];
                    nums[i]=temp;
                    flag=false;
                }else{
                    flag=true;
                }
            }
            System.out.println(Arrays.toString(nums));
            count++;
            System.out.println(flag);
            if (flag){
                System.out.println("转移了:"+count+"次");
                break;
            }
        }

    }



    public static void main(String[] args) {
        BubbleSort sort=new BubbleSort();
        int[] nums={5,1,2,3,4};
        sort.Sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
