package Sort;

import java.util.Arrays;

/**
 * 插入排序
 * 找到数的位置 ,插入数  数组第一个前面没有数,数组第一个一般不动
 * 时间复杂度
 * 最优:正序变正序O( n )
 * 最差:倒叙变正序O( n^2 )
 * 平均的时间复杂度为：O( n^2 )；
 * 空间复杂度
 * 空间复杂度为：O(1)；
 * 稳定性:稳定
 */
public class InsertionSort {
    /*
      从小到大排序
      一次循环
      4,3,2,1
      3,4,2,1
      2,3,4,1
      1,2,3,4
   */
    public void Sort(int[] nums){

        int temp=0;
        //  1,11,12,4,2,6,9,0,3,7,8,2
        for (int i = 1; i <nums.length ; i++) {
            //该方法不能直接找到该数字在新数组定位然后插入,因为后续要移动,所以只能一个一个置换到那个位置
            //nums[index] 定位当前数字
            int index=i;
            //=0会数组越界nums[index-1]
            while (0<index){
                //当前元素与当前元素前一个做比较进行置换,全程跟踪index
                //如果>=就不是稳定的,相同元素也会置换
                if (nums[index-1]>nums[index]){
                    temp=nums[index];
                    nums[index]=nums[index-1];
                    nums[index-1]=temp;
                    //向前置换
                    index--;
                    System.out.println(Arrays.toString(nums));
                }else{
                    //如果当前元素大于当前元素前一个可以跳出该循环了,这个值已经定位了
                    break;
                }
            }
        }

    }

    public static void main(String[] args) {
        InsertionSort sort=new InsertionSort();
        //int[] nums={5,1,2,3,4};
        int[] nums={1,11,12,4,2,6,9,0,3,7,8,2};
        sort.Sort(nums);
        //System.out.println(Arrays.toString(nums));
    }
}
