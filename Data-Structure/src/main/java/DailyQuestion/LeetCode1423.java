package DailyQuestion;

/**
 *
 几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
 每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
 你的点数就是你拿到手中的所有卡牌的点数之和。
 给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
 *
 * 输入：cardPoints = [1,2,3,4,5,6,1], k = 3
 * 输出：12
 * 解释：第一次行动，不管拿哪张牌，你的点数总是 1 。但是，先拿最右边的卡牌将会最大化你的可获得点数。最优策略是拿右边的三张牌，最终点数为 1 + 6 + 5 = 12 。
 *
 * 方法:滑动窗口
 */
public class LeetCode1423 {
    public  static int maxScore(int[] cardPoints, int k) {
        //判断
        if (cardPoints==null){
            return 0;
        }
        //滑动窗口的左边界
        int left=0;
        //滑动窗口的右边界
        int right=cardPoints.length-k-1;
        //目标数组的总和
        int count=0;
        //滑动窗口每次滑动的总和
        int temp=0;
        for (int i = left; i <=right ; i++) {
            temp+=cardPoints[i];
        }
        //第一次将temp赋值给sum
        int sum=temp;
        while (right<cardPoints.length-1){
            right++;
            temp=temp + cardPoints[right] - cardPoints[left];
            //每次获得滑动窗口最小的值
            sum = Math.min(sum,temp);
            left++;
        }
        //数组总和
        for (int i = 0; i <cardPoints.length ; i++) {
            count+=cardPoints[i];
        }
        //获得最大的值
        return count-sum;
    }

    public static void main(String[] args) {
        int[] nums={9,7,7,9,7,7,9};
        int res = maxScore(nums, 7);
        System.out.println(res);
    }
}
