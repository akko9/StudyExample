package DailyQuestion;

public class LeetCode643 {
    public  static double findMaxAverage(int[] nums, int k) {
        if (nums==null || k==0){
            return 0;
        }
        int left=0;
        int right=k-1;
        double sum=0;
        double temp=0;
        for (int i = 0; i <=right ; i++) {
            sum+=nums[i];
        }
        temp=sum;
        while (right<nums.length-1){
            right++;
            temp=temp+nums[right]-nums[left];
            sum = Math.max(temp, sum);
            System.out.println(sum);
            left++;
        }
        return sum/k;
    }

    public static void main(String[] args) {
        int[] nums= new int[]{1,12,-5,-6,50,3};
        double maxAverage = findMaxAverage(nums, 4);
        System.out.println(maxAverage);
    }
}
